<template>
  <div class="campaign_item" @click="goDetail()">
    <div class="thumbnail-campaign">
      <img :src="this.baseURL + mediaUrl" alt="" />
    </div>
    <div class="">
      <h4>{{ title }}</h4>
      <p>{{ content }}</p>
      <div>
        <div class="small font-weight-bold">
          <span class="ratio">{{ receiveDabo }}%</span>
          <span class="float-right" style="margin-left: 5px; margin-right: 60px"
            >5명</span
          >
          <span class="float-right">15일 남음</span>
        </div>
        <div class="progress mb-2">
          <div
            class="progress-bar bg-danger"
            role="progressbar"
            style="width: 20%"
            aria-valuenow="20"
            aria-valuemin="0"
            aria-valuemax="100"
          ></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import axios from 'axios';
import {API_BASE_URL} from "@/config/index.js"

export default {
  props: {
    campaignId: Number,
    title: String,
    content: String,
    mediaUrl: String,
    receiveDabo: Number
  },
  data() {
    return {
      campaign: [],
      baseURL: API_BASE_URL
    };
  },
  created() {
    console.log(this.campaign);
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

<style></style>
