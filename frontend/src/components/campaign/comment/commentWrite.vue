<template>
  <div class="commentInput-page">
    <div>
      <form class="form" @submit.prevent="submitForm">
        <textarea
          name="content"
          id="content"
          v-model="content"
          class="textarea_a"
          cols="30"
          rows="3"
        ></textarea>

        <button class="btn_red_comment" style="color: white" type="submit">
          등록
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/config/index.js";

export default {
  data() {
    return {
      comment: {
        commentId: 0,
        content: "",
        username: "",
        crearedAt: "",
        campaignId: 0,
      },
    };
  },
  props: {
    campaignId: Number,
  },
  methods: {
    async submitForm() {
      const commentData = {
        content: this.content,
        createdAt: this.crearedAt,
        campaignId: this.$route.params.campaignId,
      };

      console.log(commentData);

      await axios
        .post(
          API_BASE_URL +
            `/api/donationBoard/detailBoard/${this.$route.params.campaignId}/comments`,
          commentData,
          {
            headers: {
              Authorization: `Bearer ` + localStorage.getItem("accessToken"),
            },
          }
        )
        .then((res) => {
          console.log(res);
          // this.$router.push(`${this.$route.params.campaignId}`);
          this.$router.go(this.$router.currentRoute);
        });
    },
  },
};
</script>

<style>
.commentInput-page {
  margin: 0 auto;
  font-weight: bold;
}
.btn_red_comment {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 20%;
  height: 30px;
  font-size: 10px;
  float: right;
  margin-top: 5px;
}
.textarea_a {
  margin-top: 2%;
  margin-bottom: 2%;
  border-radius: 8px;
  background-color: #f6f6f6;
  border-color: #e8e8e8;
  height: 30px;
}
.textarea_a::placeholder {
  color: #bdbdbd;
  font-size: 12px;
  padding: 10px;
}
</style>
