<template>
  <div class="createBoard-page">
    <div class="submit-form">
      <p class="p_title">이미지 등록하기</p>
      <input multiple ref="image" type="file" id="files">
      <p class="p_title">제목</p>
      <input type="text" name="title" id="" placeholder="캠페인 제목">
      <p class="p_title">내용</p>
      <input type="text" name="content" id="" placeholder="캠페인 설명">
      <p class="p_title">목표 갯수</p>
      <input type="text" name="goal" id="" placeholder="목표 갯수" style="width: 80px; margin-right: 5px;">개
      <p class="p_title">마감 기한</p>
      <input type="date" name="" id="">
      <button class="btn_red">
        <span>캠페인 등록</span>
      </button>
    </div>
  </div>

</template>

<script>
export default {
};
</script>

<style>
.createBoard-page {
  margin: 0 auto;
  width: 70%;
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
