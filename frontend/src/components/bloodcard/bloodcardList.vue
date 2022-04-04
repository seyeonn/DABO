<template>
  <div class="cardlist-page">
    <div class="cardlist-header">
      <button><img src="@/assets/back.png" /></button>
    </div>
    <div class="cardlist-title">
      <span>나의 헌혈증</span>
    </div>
    <div class="d-flex cardlist-conentents">
      <div class="imoge col-4"><img src="@/assets/border-imoge.png" /></div>
      <div class="col-8">
        <span>2022.03.11 헌혈증</span>
        <p>증서번호 : 18-15963</p>
        <p>혈액원명 : SSAFY 헌혈의 집</p>
        <p>성명 : OOO</p>
        <p>헌혈종류 : 전혈 400ml</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/config";
export default {
  data() {
    return {
      name: "",
      gender: "",
      birthDate: "",
      cardNumber: "",
      donationDate: "",
      typeSelected: "",
      bloodsource: "",
    };
  },
  mounted() {
    this.getList();
  },
  methods: {
    getList() {
      axios.get(API_BASE_URL + "/api/bc/search").then((response) => {
        console.log(response);
      });
    },
  },
};
</script>

<style scoped>
.cardlist-header {
  height: 5%;
  background: #e52d27;
}
.cardlist-header button {
  margin-left: 5%;
  border: none;
  background: #e52d27;
}
.cardlist-header button img {
  width: 35%;
}
.cardlist-title {
  text-align: center;
  margin-top: 5%;
  margin-bottom: 5%;
  font-weight: 700;
}
.cardlist-conentents {
  align-items: center;
}
.cardlist-conentents .imoge {
  text-align: center;
}
.cardlist-conentents .imoge img {
  width: 85%;
}
.cardlist-conentents div {
  margin-left: 3%;
}
.cardlist-conentents div p {
  margin: 0;
}
</style>
