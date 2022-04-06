<template>
  <div class="charge-page">
    <div class="charge-header">
      <div class="d-flex header-contents">
        <div class="greeting">
          <p style="font-family: 'NicoMoji' !important;">DABO 충전하기</p>
        </div>
      </div>
    </div>
    <div class="payInfo">
      <button style="font-weight: bold;">DABO 개수</button>&nbsp;
      <button  style="color: #f08986">{{ this.selectDabo*10000 }} DABO</button>
      <br>
      <button style="font-weight: bold;">결제 금액</button>&nbsp;
      <button  style="color: #f08986">{{ this.selectDabo*10000 }} 원</button>
    </div>
  
    <div class="payable">
    <p style="font-weight: bold;">결제 수단 선택</p>
      <div class="myBtn">
        <a href="#bDonation"><button>신용카드 결제</button></a>
        <button @click="toBack()">뒤로가기</button>
      </div>
    </div>
    <div class="contents">
      <div id="bDonation" class="modal-window">
          <div>
            <p v-if="!isCashCharging">DABO를 충전하시려면 개인키를 입력해주세요</p>
              <div class="spinner" style="text-align: center; !important" v-if="isCashCharging">
                <p>충전에는 최대 약 30초가 소요됩니다.</p>
                <v-progress-circular
                  :size="70"
                  color="#f06464"
                  indeterminate
                ></v-progress-circular>
              </div>
            <sub v-if="!isCashCharging">
                <b-icon icon="exclamation-circle" style="width: 10px; height: 10px;"></b-icon>
                DABO 충전은 일정 시간의 대기 시간을 가진 뒤 자동으로 처리됩니다.
                충전 완료 후에는 취소하실 수 없으며, 관련 법령이 정하는 바에 따라 결제가 취소될 수 있습니다.
                <p></p>
            </sub>
            <div class="input-text" v-if="!isCashCharging">
              <input type="text" v-model="privateKey" placeholder="private key를 입력해주세요">
            </div>
            <div v-if="!isCashCharging">
              <a href="#">
                <button class="btn_red_cancel">
                    <span>취소하기</span>
                </button>
              </a>
              <button class="btn_red_modal" @click="checkPay()">
                  <span>충전하기</span>
              </button>
            </div>
          </div>
          
      </div>

    </div>
  </div>
</template>

<script>
import { getUserInfo } from "@/api/user.js";
import * as walletService from "@/api/wallet.js";
import { createWeb3 } from "@/utils/web3.js";
import { buyCash, getBalance } from "@/utils/cashContract.js";
import { ethToWei } from "@/utils/ethereumUnitUtils.js";
import BN from "bn.js";
export default {
  data() {
    return {
      selectDabo: 0,
      
      wallet: {
        id: 0,
        ownerId: null,
        address: "",
        balance: 0,
        payBalance : 0,
        cash: 0,
        receivingCount: 0,
      },
      isCharging: false, // 현재 코인을 충전하고 있는 중인지 확인
      isCashCharging: false, // 현재 캐시을 충전하고 있는 중인지 확인
      cashChargeAmount: 0.1,
      userId: this.$store.state.user.id,
      walletAddress: this.$store.state.user.walletAddress,
      privateKey: null,
    }
  },
  methods: {
    checkPay() {
       /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('imp00423345'); // test 가맹점을 넣어놨어요

      /* 2. 결제 데이터 정의하기 */
      const data = {
        pg: 'html5_inicis',                           // PG사
        pay_method: 'card',                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: this.selectDabo*10000,                                 // 결제금액
        name: '아임포트 결제 데이터 분석',                  // 주문명
        buyer_name: '홍길동',                           // 구매자 이름
        buyer_tel: '01012341234',                     // 구매자 전화번호
        buyer_email: 'example@example',               // 구매자 이메일
        buyer_addr: '신사동 661-16',                    // 구매자 주소
        buyer_postcode: '06018',                      // 구매자 우편번호
      };

      /* 4. 결제 창 호출하기 */
      IMP.request_pay(data, this.callback);
    },
    callback(response) {
      /* 3. 콜백 함수 정의하기 */
      const {
        success,
        error_msg,
        
      } = response;

      if (success) {
        alert('결제 성공');
        
      } else {
        alert(`결제 실패: ${error_msg}`);
        this.chargeCash()
      }
    },
    chargeCash() {
      const vm = this;
      this.isCashCharging = true;
      // const privateKey = this.privateKey;
      const privateKey = vm.privateKey;
      if (privateKey) {
        /**
         * 이더를 지불하고 캐시를 충전
         */
        buyCash(
          new BN(ethToWei(String(this.cashChargeAmount))),
          privateKey,
          function() {
            alert("캐시를 충전했습니다.");
            vm.isCashCharging = false;
            vm.fetchCashBalance();
            vm.$router.go({ path: 'dabowallet/chargeconfirm'})
          },
          function() {
            alert("캐시 충전을 실패했습니다.");
            vm.isCashCharging = false;
          }
        );
      }
    },
    fetchCashBalance() {
      const vm = this;
      getBalance(
        this.walletAddress,
        function(balance) {
          vm.wallet.cash = balance;
        },
        function(err) {
          console.error("캐시 잔액 조회 실패:", err);
        }
      );
    },
    fetchEtherBalance() {
      const vm = this;
      walletService.findByUserId(this.userId, function(res) {
        const web3 = createWeb3();
        vm.wallet.balance = web3.utils.fromWei(
          res.data.balance.toString(),
          "ether"
        );
      });
    },
    fetchUserInfo(){
      // const vm = this;
      getUserInfo(
            function (response) {
              console.log("getUserInfo",response);
              // vm.user.email = response.data.email;
              // vm.user.nickname = response.data.nickname;
            },
            function (err) {
              if (err.response != 404) {
                console.error(err);
                // alert("유저 정보를 찾지 못했습니다.");
              }
            }
          );
    },
    fetchWalletInfo() {
      const vm = this;

      walletService.findByUserId(this.userId, function(response) {
        const data = response.data;
        const web3 = createWeb3();
        data["balance"] = web3.utils.fromWei(
          data["balance"].toString(),
          "ether"
        );
        vm.wallet = data;
      });
    },
    toBack() {
      this.$router.push({name: 'daboWallet'})
    }
  },
  mounted() {
    this.fetchWalletInfo();
    // this.fetchUserInfo();
  },
  created() {
    this.selectDabo = this.$route.params.selected
  }
}
</script>

<style scoped>
.spinner {
  text-align: center;
}
.greeting p {
  margin-right: 40px;
  margin-top: 30px;
}

.charge-page {
  overflow: scroll;
}
.charge-header {
  background-color: #e52d27;
  height: 24vh;
  justify-content: space-between;
  align-items: center;
}
.header-contents {
  justify-content: center;
  padding: 15px;
}
.greeting {
  font-weight: bold;
  font-size: 30px;
  text-align: center;
  color: white;
}
.greeting p {
  margin-left: 50px;
}



.myBtn button {
  display: block;
  margin: auto;
  background-color: white;
  color: black;
  border: none;
  border-radius: 10px 10px;
  width: 90%;
  margin-top: 10px;
  margin-bottom: 5px;
  box-shadow: 1px 1px;
  font-weight: bold;
}


.payInfo {
  text-align: center;
  margin-top: 50px;
}
.payInfo button {
  display: inline-block;
  margin: auto;
  background-color: white;
  color: black;
  border: none;
  border-radius: 3px 3px;
  width: 30%;
  margin-top: 10px;
  margin-bottom: 5px;
  box-shadow: 1px 1px;
  font-weight: bold;
}

.payable {
  margin-top: 50px;
  margin-left: 20px;
}

.input-text input {
  width: 90%;
  height: 32px;
  font-size: 15px;
  border: 0;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
}
</style>