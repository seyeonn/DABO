<template>
  <div class="login-page">
    <p class="header">Log In</p>
    <form>
      <div class="submit-form">
        <input type="email" name="email" placeholder="Email" />
        <input type="password" name="password" placeholder="Password" />
        <div class="btn_findpw">
          <button>Forget yout password?</button>
        </div>
        <button class="btn_red">
          <span>Login</span>
        </button>
        <button class="btn_social">
          <img src="@/assets/kakao_login_medium_wide.png" />
        </button>
        <button class="btn_red">
          <span>SignUp</span>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {};
</script>

<style>
.login-page {
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
  margin: 1%;
  width: 100%;
  height: 35px;
  font-size: 12px;
  font-weight: bold;
}
.btn_social {
  background-color: #fee500;
  color: #fff;
  border-radius: 10px;
  border: none;
  margin: 1%;
  width: 100%;
  height: 35px;
  font-size: 12px;
  font-weight: bold;
}
.btn_social img {
  height: -webkit-fill-available;
}
.btn_findpw {
  float: right;
  margin-bottom: 10%;
}
.btn_findpw button {
  border: none;
  background: none;
  font-size: 12px;
}
.header {
  margin-top: 10%;
  margin-bottom: 10%;
  font-size: x-large;
  font-family: "NicoMoji" !important;
}
.submit-form input {
  width: 100%;
  height: 35px;
  margin-top: 2%;
  margin-bottom: 2%;
  border-radius: 8px;
  background-color: #f6f6f6;
  border: 1px solid #e8e8e8;
}
.submit-form input::placeholder {
  color: #bdbdbd;
  font-size: 12px;
  padding: 10px;
}
</style>
