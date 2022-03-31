<template>
  <div class="ranking-page">
    <div class="contents-title d-flex">
      <div><p>My Ranking</p></div>
      <div class="d-flex">
        <button class="btn-plus"><img src="@/assets/question.png" /></button>
      </div>
    </div>
    <div class="contents-rank">
      <div class="imoge"><img src="@/assets/medal3.png" /></div>
      <div>
        <p>27 badge<br />52 Point</p>
        <button class="share">SHARE</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.contents-title {
  font-weight: bold;
}
.contents-rank {
  text-align: center;
  height: 25vh;
  margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%;
  border-radius: 15px;
  box-shadow: 0 1px 1px rgb(0 0 0 / 25%), 0 2px 2px rgb(0 0 0 / 20%),
    0 4px 4px rgb(0 0 0 / 15%), 0 8px 8px rgb(0 0 0 / 10%);
}
.share {
  font-weight: bold;
  border-radius: 20px;
  padding: 1%;
  padding-left: 3%;
  padding-right: 3%;
}
</style>
