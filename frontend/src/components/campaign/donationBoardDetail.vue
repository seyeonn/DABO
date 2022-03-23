<template>
    <div class="detailBoard-page">
        <div>
            <img src="https://i.imgur.com/httN9Bm.png" class="campaign-detail-img" alt="">
            <h4>캠페인 제목</h4>
            <p>캠페인 설명</p>
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
        <comment-write />
        <comment-list/>
        <!-- <campagin-comment></campagin-comment> -->
        <div>
        <span>
        <button class="btn_red_campaign" style="margin-right: 10px; margin-left: 7px;"><span>헌혈증 기부하기</span></button>
        <button class="btn_red_campaign"><span>DABO로 후원하기</span></button>
        </span>
        </div>
    </div>
</template>

<script>
import CommentWrite from "@/components/campaign/comment/commentWrite.vue";
import CommentList from "@/components/campaign/comment/commentList.vue";

export default {
    data() {
        return {

        }
    },
    components: {
        CommentWrite,
        CommentList
    }
}
</script>

<style>
.detailBoard-page {
  margin: 0 auto;
  width: 70%;
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
  margin-bottom: 5px;
}
</style>