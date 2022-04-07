<template>
  <div class="campaign_item" @click="goDetail()">
    <div class="thumbnail-campaign">
      <img :src="this.baseURL + mediaUrl" alt="" />
    </div>
    <div class="">
      <h4 class="donation-title">{{ title }}</h4>
      <p>{{ content }}</p>
      <div>
        <div class="su-campaign small font-weight-bold d-flex">
          <div>
            <span class="ratio">{{ process }}</span>
            <span
              class="float-right"
              style="margin-left: 5px; margin-right: 60px"
              >헌혈증 {{ receiveBloodCard }} / {{ amount }}
            </span>
          </div>
          <span class="float-right">{{ dueDate }}일 남음</span>
        </div>
        <div class="progress mb-2">
          <div
            class="progress-bar bg-danger"
            role="progressbar"
            aria-valuenow="20"
            aria-valuemin="0"
            aria-valuemax="100"
            :style="{ width: progress }"
          >
            {{ progress }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import axios from 'axios';
import { API_BASE_URL } from "@/config/index.js";

export default {
  props: {
    campaignId: Number,
    title: String,
    content: String,
    mediaUrl: String,
    receiveBloodCard: Number,
    receiveDabo: Number,
    amount: Number,
    target: String,
    deadLine: String,
  },
  data() {
    return {
      campaign: [],
      baseURL: API_BASE_URL,
      progress: "",
      dueDate: "",
    };
  },
  created() {
    console.log(this.amount);
    this.progress =
      Math.round(
        (0.5 * (this.receiveBloodCard / this.amount) +
          0.5 * (this.receiveDabo / this.target)) *
          100 *
          100
      ) /
        100 +
      "%";
    const strDate = this.deadLine.split("-");
    const date = new Date(strDate[0], strDate[1] - 1, strDate[2]);
    const today = new Date();
    this.dueDate = Math.ceil((date - today) / (1000 * 60 * 60 * 24));

    console.log(this.progress);
  },
  methods: {
    goDetail() {
      this.$router.push({
        name: "detailBoard",
        params: { campaignId: this.campaignId },
      });
    },
  },
};
</script>

<style scoped>
.thumbnail-campaign img {
  margin-top: 2%;
  margin-bottom: 5%;
}
.donation-title {
  font-weight: bold;
}
.progress-bar {
  width: 20%;
  background-color: #f06464 !important;
}
.su-campaign {
  justify-content: space-between;
  align-items: center;
}
</style>
