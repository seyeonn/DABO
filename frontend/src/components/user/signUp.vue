<template>
  <div class="signup-page">
    <p class="header">Sign Up</p>
    <form class="form" @submit.prevent="submitForm">
      <div class="submit-form">
        <input type="text" name="name" placeholder="Name" v-model="name" />
        <div class="input-check">
          <input
            type="text"
            name="nickname"
            placeholder="NickName"
            v-model="nickname"
          />
          <button class="btn_input btn_red col-2">
            <span>check</span>
          </button>
        </div>
        <div class="input-bloodtype">
          <span>Blood Type</span>
          <div class="form_radio_btn d-flex">
            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice1"
              name="contact"
              value="A"
            />
            <label for="contactChoice1">A</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice2"
              name="contact"
              value="B"
            />
            <label for="contactChoice2">B</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice3"
              name="contact"
              value="AB"
            />
            <label for="contactChoice3">AB</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice4"
              name="contact"
              value="O"
            />
            <label for="contactChoice4">O</label>
          </div>
        </div>

        <div class="input-check d-flex">
          <input
            class=""
            type="email"
            v-model="email"
            name="email"
            placeholder="Email"
          />
          <button class="btn_input btn_red col-2">
            <span>check</span>
          </button>
        </div>
        <input
          type="password"
          v-model="password"
          name="password"
          placeholder="Password"
        />
        <input
          type="password"
          v-model="passwordConfirm"
          name="passwordChk"
          placeholder="Password Check"
        />
        <button type="submit" class="btn_red">
          <span>SignUp</span>
        </button>
        <button v-on:click="createWallet">지갑주소 생성하기</button>
        <p>{{ privateKey }}</p>
        <p>{{ walletAddress }}</p>

        <button v-on:click="saveWallet">서버에 저장</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import { registerWallet } from "@/api/wallet.js";
import Web3 from "web3";
import { API_BASE_URL } from "@/config";

export default {
  data() {
    return {
      name: "",
      nickname: "",
      bloodtype: "",
      email: "",
      password: "",
      passwordConfirm: "",
      privateKey: "",
      walletAddress: "",
      userId : 1,
    };
  },
  methods: {
    async submitForm() {
      const userData = {
        name: this.name,
        nickname: this.nickname,
        bloodType: this.bloodtype,
        email: this.email,
        password: this.password,
        passwordConfirm: this.passwordConfirm,
      };

      console.log(userData);

      const response = await axios

        .post(API_BASE_URL + "/api/user/signUp", userData)
        .then((res) => {
          console.log(res);
          // this.$router.push("login");
        });
      console.log(response);
    },

    createWallet: function () {
      /**
       * 지갑 주소와 private key를 생성
       *
       */
      
      var web3 = new Web3();

      var wallet = web3.eth.accounts.create("DABO_WALLET");
      this.walletAddress = wallet.address;
      this.privateKey = wallet.privateKey;
      
    },

    saveWallet: function () {
      /**
       * 생성된 사용자의 지갑 정보(주소, private key) 를 서버에 등록한다.
       */

      var vm = this;

      registerWallet(this.userId, this.walletAddress, function(res) {
        
        vm.$store.commit("setWalletAddress", res.data.address);
        alert("지갑 주소가 등록되었습니다.");

        vm.$router.push("login");
      });

      
    }
    

  } 
};
</script>

<style scoped>
.signup-page {
  text-align: -webkit-center;
  margin: 0 auto;
  width: 70%;
  font-weight: bold;
}
.btn_red {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 100%;
  font-size: 12px;
}
.header {
  margin-top: 10%;
  margin-bottom: 10%;
  font-size: x-large;
}
.submit-form input {
  width: 100%;
  height: 35px;
  margin-top: 2%;
  margin-bottom: 2%;
  border-radius: 8px;
  background-color: #f6f6f6;
  border-color: #e8e8e8;
}
.submit-form input::placeholder {
  color: #bdbdbd;
  font-size: 12px;
  padding: 10px;
}
.input-check {
  position: relative;
}
.btn_input {
  position: absolute;
  right: 1%;
  top: 5px;
  height: 29px;
}

.input-bloodtype span {
  margin-top: 5%;
  font-size: 12px;
  float: left;
}

.form_radio_btn {
  width: 100%;
  height: 40px;
  border: 1px solid #eae7e7;
  border-radius: 8px;
  margin-bottom: 10px;
}
.form_radio_btn input[type="radio"] {
  display: none;
}
.form_radio_btn label {
  width: 25%;
  display: block;
  border-radius: 8px;
  margin: 0 auto;
  text-align: center;
  height: -webkit-fill-available;
  line-height: 45px;
}

.form_radio_btn input[type="radio"]:checked + label {
  background: #e52d27a1;
  color: #fff;
}

.form_radio_btn label:hover {
  color: #666;
}

.form_radio_btn input[type="radio"] + label {
  background: #f9fafc;
  color: #666;
}
</style>
