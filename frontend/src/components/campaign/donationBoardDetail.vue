<template>
    <div>
      <div class="dabo_header">
        <h2 class="dabo_title">캠페인 상세 보기</h2>
      </div>
      <div class="detailBoard-page">
        <div>
            <img :src="'http://localhost:8080'+campaign.mediaUrl" class="campaign-detail-img" alt="">
            <h4>{{ title }}</h4>
            <p>{{ content }}</p>
            <div>
                <div class="small font-weight-bold">
                    <span class="ratio">20%</span> 
                    <span class="float-right">15일 남음</span>
                    </div>
                      <div class="progress mb-2">
                        <div class="progress-bar bg-danger" role="progressbar" style="width: 20%"
                                    aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </div>
            <sub>n명의 후원자가 있습니다.</sub>
        </div>
        <div class="cpn-btn">
            <span>
              <button class="btn_red_campaign" style="margin-right: 10px; margin-left: 7px;" @click="goDonationDetail()"><span>헌혈증 기부하기</span></button>
              <button class="btn_red_campaign" @click="goDaboDonationDetail()"><span>DABO로 후원하기</span></button>
            </span>
        </div>
        <div class="line"></div>
        <!-- 댓글 -->
        <!-- <comment-write v-if="isModifyShow && this.modifyComment != null"
            :modifyComment="this.modifyComment"
            @modify-comment-cancel="onModifyCommentCancel"
        />
        <comment
         v-for="(comment, index) in comments"
          :key="index"
          :comment="comment"
          @modify-comment="onModifyComment"
        /> -->
        <comment-write @setCampaignId="setCampaignId"/>
        <comment-list
         v-for="comment in comments"
          :key="comment.id"
          v-bind="comment"
          :comment="comment"
        />
        <!-- <campagin-comment></campagin-comment> -->
        </div>
    </div>
</template>

<script>
import CommentWrite from "@/components/campaign/comment/commentWrite.vue";
import CommentList from "@/components/campaign/comment/commentList.vue";
import axios from 'axios';
import {API_BASE_URL} from "@/config/index.js"

export default {
    name: "detailBoard",
    data() {
        return {
          campaign: [],
          content: '',
          title: '',
          walletAddressOfBoard:'',
          comments: [],
        }
    },
    async created() { 
      axios
        .get(API_BASE_URL+`/donationBoard/detailBoard/${this.$route.params.campaignId}`)
        .then((res) => {
          console.log(res.data);
          this.content = res.data.content;
          this.title = res.data.title;
          this.walletAddressOfBoard = res.data.walletAddress;
          console.log(this.campaign);
        });

      await axios
        .get(API_BASE_URL+`/donationBoard/detailBoard/${this.$route.params.campaignId}/comments`)
        .then((res) => {
          console.log(res.data);
          this.comments = res.data;
          console.log(this.comments);
        });
    },
    components: {
        CommentWrite,
        CommentList
    },
    methods: {
      goDonationDetail() {
        this.$router.push({name: 'myDonation',params:''})
      },
      setCampaignId(campaignId) {
        this.campaignId = campaignId;
      },
      goDaboDonationDetail(){
        this.$router.push({name: 'daboDonation', params: {toAddress: this.walletAddressOfBoard}})
      }
    }
}
</script>

<style>
.detailBoard-page {
  margin: 0 auto;
  width: 90%;
  font-weight: bold;
}
.btn_red_campaign {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 45%;
  height: 35px;
  font-size: 12px;
}
.header {
  margin-top: 10%;
  margin-bottom: 10%;
  font-size: x-large;
}
.ratio {
  color:#e52d27;
  font-size: 20px;
  font-weight: 3px;
  margin-right: 10px;
}
.campaign-detail-img {
  width: 100%;
  height: 200px;
}
.line {
  border-top: 2px solid rgb(211, 211, 211);
  margin-top: 10px;
  margin-bottom: 10px;
}
.cpn-btn {
  margin-top: 13px;
  margin-bottom: 13px;
}
</style>