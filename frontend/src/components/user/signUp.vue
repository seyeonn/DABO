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
          type="passwordChk"
          v-model="passwordConfirm"
          name="passwordChk"
          placeholder="Password Check"
        />
        <button type="submit" class="btn_red">
          <span>SignUp</span>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      name: "",
      nickname: "",
      bloodtype: "",
      email: "",
      password: "",
      passwordConfirm: "",
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
        .post("http://localhost:9090/api/user/signUp", userData)
        .then((res) => {
          console.log(res);
          this.$router.push("login");
        });
      console.log(response);
    },
  },
};
</script>

<style>
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
