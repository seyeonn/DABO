<template>
  <div>
    <div class="main-header">
      <div class="btn-alert">
        <button><img src="@/assets/bell.png" /></button>
      </div>
      <div class="d-flex header-contents">
        <div class="greeting">
          <p>OO님 <br />안녕하세요!</p>
        </div>
        <div class="btn-profile">
          <button><img src="@/assets/profile.png" /></button>
        </div>
      </div>
    </div>
    <div class="contents">
      <div class="div-bloodcard">
        <div class="contents-title d-flex">
          <div><p>내 헌혈증 기록</p></div>
          <div class="d-flex">
            <p>등록하기</p>
            <button class="btn-plus"><img src="@/assets/plus.png" /></button>
          </div>
        </div>
        <div class="contents-bloodcard d-flex">
          <div class="imoge"><img src="@/assets/imoge.png" /></div>
          <div>
            <p>나의 헌혈증은 3개 입니다.<br />나의 기부 뱃지는 2개 입니다.</p>
          </div>
        </div>
        <div class="detail-show"><button>자세히 보기</button></div>
      </div>
      <div class="div-donation"></div>
      <div class="div-ranking"></div>
      <div class="div-bloodreserve"></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.main-header {
  background-color: #e52d27;
  height: 24vh;
  justify-content: space-between;
  align-items: center;
}
.btn-alert {
  display: inline-block;
  width: 100%;
}
.btn-alert button {
  margin-right: 3%;
  margin-top: 3%;
  float: right;
  border: none;
  background-color: #e52d27;
}
.btn-alert button img {
  width: 30px;
}
.header-contents {
  justify-content: center;
}
.greeting {
  margin-right: 15%;
  font-weight: bold;
  font-size: 30px;
  text-align: center;
}
.btn-profile button {
  float: right;
  border: none;
  background-color: #e52d27;
}
.btn-profile button img {
  width: 80px;
}
.contents .div-bloodcard {
  font-weight: bold;
}
.contents-title {
  margin-top: 10%;
  margin-left: 10%;
  margin-right: 10%;
  align-items: center;
  justify-content: space-between;
}
.contents-title div {
  align-items: center;
}
.contents-title div p {
  margin: 0;
}
.contents .div-bloodcard {
  font-weight: bold;
}
.btn-plus {
  border: none;
  background-color: #fff;
}
.btn-plus img {
  width: 30px;
}
.contents-bloodcard {
  height: 20vh;
  margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%;
  border-radius: 15px;
  box-shadow: 0 1px 1px rgb(0 0 0 / 25%), 0 2px 2px rgb(0 0 0 / 20%),
    0 4px 4px rgb(0 0 0 / 15%), 0 8px 8px rgb(0 0 0 / 10%);
}
.contents-bloodcard div {
  align-self: center;
  text-align: center;
  margin-left: 5%;
}
.imoge img {
  width: 80px;
}
.detail-show {
  position: absolute;
  right: 10%;
  transform: translate(0px, -24px);
  font-size: small;
  font-weight: normal;
}
.detail-show button {
  border: none;
  background: #fff;
}
</style>
