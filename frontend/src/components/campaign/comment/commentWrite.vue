<template>
    <div class="commentInput-page">
        <!-- <div v-if="this.modifyComment != null" class="regist_form"> -->
        <div>
            <form class="form" @submit.prevent="submitForm">
            <textarea name="content" id="" v-model="comment.content" class="text_comment" cols="30" rows="3"></textarea>
            <div class="btn_div">
                <button
                class="btn_red_comment"
                style="margin-left: 5px;"
                @click="updateCommentCancel"
                >
                취소
                </button>
                <button
                class="btn_red_comment"
                @click="updateComment"
                >
                <!-- 수정 -->
                등록
                </button>
            </div>
            </form>
        </div>

        <!-- <div v-else class="regist_form">
            <textarea
                id="comment"
                name="comment"
                v-model="comment"
                cols="35"
                rows="2"
            ></textarea>
            <button
                class="g-actions-button23 g-actions-button23-default"
                @click="registComment"
            >
                등록
            </button>
        </div> -->
    </div>
</template>

<script>
//import axios from "axios";
//import { API_BASE_URL } from "../../config";

export default {
    data() {
        return {
            comment: {
                commentId: 0,
                content: "",
                username: "",
                crearedAt: "",
                campiagnId: ""
            }
        }
    },
    methods: {
        async SubmitForm() {
            const commentData = {
                commentId: this.commentId,
                content: this.content,
                createdAt: this.crearedAt,
                username: this.username,
                campiagnId: this.campiagnId
            };

            console.log(commentData);

    //         const response = await axios
    //             .post(API_BASE_URL + `/detailBoard/${this.campaignId}/comments`, commentData)
    //             .then((res) => {
    //             console.log(res);
    //             this.$router.push(`/detailBoard/${this.campaignId}`);
    //     });
    //   console.log(response);
        }
    }
}
</script>

<style>
.commentInput-page {
  margin: 0 auto;
  height: 120px;
  font-weight: bold;
}
.btn_red_comment {
    background-color: #e52d27;
    color: #fff;
    border-radius: 10px;
    border: none;
    width: 20%;
    height: 25px;
    font-size: 10px;
    float:right;
}
</style>