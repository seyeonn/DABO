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
      <button style="font-weight: bold;">DABO 개수</button>
      <button  style="color: #f08986">200 DABO</button>
      <hr class="fade">
      <button style="font-weight: bold;">결제 금액</button>
      <button  style="color: #f08986">20000 원</button>
    </div>

    <p style="font-weight: bold;">결제 수단 선택</p>

      <div class="myBtn">
        <button @click="checkPay()">신용카드 결제</button>
      </div>
    <div class="contents">


    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectDabo: 0,
    }
  },
  methods: {
    checkPay() {
      this.$router.push({name: 'chargeConfirm', params: ''})
    }
  }
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



.myBtn button {
  display: block;
  margin: auto;
  background-color: white;
  color: black;
  border: none;
  border-radius: 5px 5px;
  width: 90%;
  margin-top: 10px;
  margin-bottom: 5px;
  box-shadow: 1px 1px;
}


.payInfo {
  text-align: center;
}
.payInfo button {
  background: white;
  border: none;
  color: black;
  border-radius: 8px;
}

.fade {
  height: 1px;
  background-image: linear-gradient(
    90deg,
    hsla(0, 0%, 100%, 0),
    hsla(0, 0%, 100%, 0.5) 50%,
    hsla(0, 0%, 100%, 0) 100%);
}

</style>