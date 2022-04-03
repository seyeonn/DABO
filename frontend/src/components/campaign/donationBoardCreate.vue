<template>
  <div>
    <div class="dabo_header">
      <h2 class="dabo_title">캠페인 등록</h2>
    </div>
    <div class="createBoard-page">
      <form class="form" @submit.prevent="submitForm">
      <div class="submit-form">
        <p class="p_title">이미지 등록하기</p>
        <input multiple ref="image" name="mediaUrl" type="file" id="files">
        <p class="p_title">제목</p>
        <input type="text" name="title" v-model="campaign.title" id="" placeholder="캠페인 제목">
        <p class="p_title">내용</p>
        <input type="text" name="content" v-model="campaign.content" id="" placeholder="캠페인 설명">
        <p class="p_title">목표 갯수</p>
        <input type="text" name="amount" v-model="campaign.amount" id="" placeholder="목표 갯수" style="width: 80px; margin-right: 5px;">개
        <p class="p_title">목표 DABO</p>
        <input type="text" name="target" v-model="campaign.target" id="" placeholder="목표 DABO" style="width: 80px; margin-right: 5px;">DABO
        <p class="p_title">마감 기한</p>
        <input type="date" name="deadline" v-model="campaign.deadline" id="">
        <button type="submit" class="btn_red">
          <span>캠페인 등록</span>
        </button>
      </div>
      </form>
    </div>
  </div>

</template>

<script>
import axios from "axios";
import {API_BASE_URL} from "@/config/index.js"
export default {
  data() {
    return {
      campaign: {
        campaignId: 0,
        title: "",
        content: "",
        amount: 0,
        target: "",
        deadline: "",
        mediaUrl: "",
        walletAddress: ""
      }
    
    }
  },
  methods: {
    async submitForm() {
      const campaginData = {
        campaignId : this.campaignId,
        title: this.title,
        content: this.content,
        amount: this.amount,
        target: this.target,
        deadline: this.deadline,
        mediaUrl: this.mediaUrl,
        walletAddress: this.walletAddress
      };

      console.log(campaginData);

      const response = await axios
        .post(API_BASE_URL+"/donationBoard/createBoard", campaginData)
        .then((res) => {
          console.log(res);
          this.$router.push("listBoard");
        });
      console.log(response);
    }
  }
};
</script>

<style>
.createBoard-page {
  margin: 0 auto;
  width: 90%;
  font-weight: bold;
}
.btn_red {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 100%;
  height: 35px;
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
.p_title {
  margin-top: 10px;
  margin-bottom: 0px;
}
</style>
