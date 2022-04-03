<template>
  <div class="charge-page">
    <div class="charge-header">
      <div class="d-flex header-contents">
        <div class="greeting">
          <p style="font-family: 'NicoMoji' !important;">DABO 충전하기</p>
        </div>
      </div>
    </div>

    <div class="contents">
      <!-- header -->
      <p>충전하실 DABO 개수를 선택해주세요</p>

      <!-- wallet -->
      <div class="contents-wallet d-flex">
        <div>
          <span>DABO Token 보유 현황</span><br>
          <span style="font-weight: lighter">{{ $store.state.wallet.cash }} DABO</span><br>
          <span>내 지갑 주소</span><br>
          <span style="font-weight: lighter">{{ $store.state.user.walletAddress }}</span>
        </div>
      </div>

      <br/>
      <!-- select dabo -->
      <div class="form_radio_group">
        <div class="form_radio_group-item">
          <input id="radio-1" type="radio" name="radio" value="1" v-model="selectDabo" checked>
          <label for="radio-1">10000 DABO</label>
        </div>
        <div class="form_radio_group-item">
          <input id="radio-2" type="radio" name="radio" value="2" v-model="selectDabo">
          <label for="radio-2">20000 DABO</label>
        </div>
        <div class="form_radio_group-item">
          <input id="radio-3" type="radio" name="radio" value="3" v-model="selectDabo">
          <label for="radio-3">30000 DABO</label>
        </div>
        <div class="form_radio_group-item">
          <input id="radio-4" type="radio" name="radio" value="4" v-model="selectDabo">
          <label for="radio-4">40000 DABO</label>
        </div>
        <div class="form_radio_group-item">
          <input id="radio-5" type="radio" name="radio" value="5" v-model="selectDabo">
          <label for="radio-5">50000 DABO</label>
        </div>
        <div class="form_radio_group-item">
          <input id="radio-6" type="radio" name="radio" value="6" v-model="selectDabo">
          <label for="radio-6">60000 DABO</label>
        </div>
      </div>

      <!-- <button class="btn_red col-2" @click="goCreata()">
        <span>충전하기</span>
      </button> -->
      
      
      <br/>
      <br/>
      <p> 밑에 테스트용 버튼들입니다. payDabo연결해주시면 거기에다가 붙혀놓을 수 있습니다~!</p>
      <br/>
      <button @click="chargeCash">10000 DABO 충전 Test </button>
      <br/>
      <br/>
      <button @click="onPayment">결제 시스템 사용 DABO 충전 TEst </button>
      <br/>
      <br/>

    </div>

  </div>
</template>

<script>

//payDabo로 보낼 것들
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
        payBalance: 0,
        cash: 0,
        receivingCount: 0,
      },
      user:{
        email : "",
        nickname: ""
      },
      isCharging: false, // 현재 코인을 충전하고 있는 중인지 확인
      isCashCharging: false, // 현재 캐시을 충전하고 있는 중인지 확인
      cashChargeAmount: 0.1,
      userId: this.$store.state.user.id,
    }
  },
  methods: {
     onPayment() {
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('imp00423345');

      /* 2. 결제 데이터 정의하기 */
      const data = {
        pg: 'html5_inicis',                           // PG사
        pay_method: 'card',                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: this.cashChargeAmount * 10000,                                 // 결제금액
        name: 'DABO Token 충전',                  // 주문명
        buyer_name: this.user.nickname,                           // 구매자 이름
        buyer_tel: '01012341234',                     // 구매자 전화번호
        buyer_email: this.user.email,               // 구매자 이메일
        buyer_addr: '신사동 661-16',                    // 구매자 주소
        buyer_postcode: '06018',                      // 구매자 우편번호
        
      };
// this.cashChargeAmount = data.amount;
      /* 4. 결제 창 호출하기 */
    IMP.request_pay(data, this.callback)
    },
    callback(response) {
      /* 3. 콜백 함수 정의하기 */
      const {
        success,
        error_msg,
        
      } = response;

      if (success) {
        
        alert('결제 성공 -> 캐쉬를 충전하겠습니다');
        this.chargeCash();
      } else {
        alert(`결제 실패: ${error_msg}`);
        // this.chargeCash()
      }
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
    chargeCash() {
      const vm = this;
      this.isCashCharging = true;
      const privateKey = prompt("캐시를 충전하시려면 개인키를 입력하세요.");
      if (privateKey) {
        buyCash(
          new BN(ethToWei(String(this.cashChargeAmount))),
          privateKey,
          function() {
            alert("캐시를 충전했습니다.");
            vm.isCashCharging = false;
            vm.fetchCashBalance();
            vm.fetchEtherBalance();
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
      const vm = this;
      getUserInfo(
            function (response) {
              console.log("getUserInfo",response);
              vm.user.email = response.data.email;
              vm.user.nickname = response.data.nickname;
            },
            function (err) {
              if (err.response != 404) {
                console.error(err);
                // alert("유저 정보를 찾지 못했습니다.");
              }
            }
          );
    }

  },
  mounted() {
    this.fetchWalletInfo();
    this.fetchUserInfo();
  },
}
</script>

<style>
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

.contents p {
  text-align: center;
  font-size: 20px;
}

.contents .div-wallet {
  font-weight: bold;
}
.contents-wallet {
  height: 20vh;
  margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%;
  border-radius: 15px;
  box-shadow: 0 1px 1px rgb(0 0 0 / 25%), 0 2px 2px rgb(0 0 0 / 20%),
    0 4px 4px rgb(0 0 0 / 15%), 0 8px 8px rgb(0 0 0 / 10%);
}
.contents-wallet div {
  align-self: center;
  margin-left: 5%;
}

.form_radio_group {
	display: inline-block;
	overflow: hidden;
}
.form_radio_group-item {
	display: inline-block;
	float: left;    
  color: #f08986;
}
.form_radio_group input[type=radio] {
	display: none;
}
.form_radio_group label {
	display: inline-block;
	cursor: pointer;
	padding: 0px 15px;
	line-height: 34px;
	border: 1px solid #f08986;
	border-right: none;
	user-select: none;
}

.form_radio_group .form_radio_group-item:first-child label {
	border-radius: 6px 0 0 6px;
}
.form_radio_group .form_radio_group-item:last-child label {
	border-radius: 0 6px 6px 0;
	border-right: 1px solid #999;
}

/* Checked */
.form_radio_group input[type=radio]:checked + label {
	background: #f08986;
  color: white;
}

/* Hover */
.form_radio_group label:hover {
	color: #666;
}


.btn_red {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 100%;
  height: 35px;
  font-size: 12px;
  float: right;
}
</style>