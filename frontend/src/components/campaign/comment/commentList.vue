<template>
<div>
    <div class="container">
        <div class="campaign_item">
            <div class="row">
                <div class="col-3">
                    <img src="https://i.imgur.com/httN9Bm.png" class="comment-img" alt="">
                </div>
                <div class="col-9">
                    <div class="content">
                        <p class="c2">
                        <!-- {{ comment.userid }} -->
                        <!-- <span class="c3">({{ comment.memotime }})</span> -->
                        김싸피
                        <span class="c3">2022.03.23</span>
                        </p>
                    </div>
                    <!-- <div class="content" v-html="enterToBr(comment.comment)"></div> -->
                    <div class="content">힘내세요!</div>
                    <div class="cbtn">
                        <label @click="modifyCommentView">수정</label> |
                        <label @click="deleteComment">삭제</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>    
</template>

<script>
export default {
    data() {
        return {

        }
    },
    props: {
    },
    methods: {}
}
</script>

<style>
.comment {
  text-align: left;
  border-radius: 5px;
  background-color: #d6e7fa;
  padding: 10px 20px;
  margin: 10px;
  color: rgb(110, 110, 110);
}
.head {
  margin-bottom: 5px;
}
.content {
  padding: 5px;
  font-size: 13px;
}
.cbtn {
  text-align: right;
  color: #e52d27;
  margin: 5px 0px;
  font-size: 12px;
}
.c1 {
  font-size: 13px;
  color: rgb(136, 136, 136);
  float: right;
}
.c2 {
    margin-bottom: 0px;
}
.c3 {
  font-size: 12px;
  color: rgb(151, 151, 151);
}
.comment-img {
    width: 60px;
    height: 60px;
    border-radius: 20px;;
}
</style>