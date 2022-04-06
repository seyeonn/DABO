<template>
<div class="campaign_item">
  <h4>{{ housename }}</h4>
  <p>주소 : {{ address }}</p>
  <p>전화번호 : {{ telephone }}</p>
  <button class="btn_red_res" @click="reserve()">
    <span>예약</span>
  </button>
</div>
</template>

<script>
export default {
    props: {
      bloodHouseId: Number,
      housename: String,
      address: String,
      telephone: String
    },
    data() {
      return {
        bloodHouse: [],
      }
    },
    methods: {
      reserve() {
         this.$router.push({name: 'nowReservation', params: {bloodHouseId: this.bloodHouseId} })
      }
    }
}
</script>

<style>
    .btn_red_res {
      background-color: #e52d27;
      color: #fff;
      border-radius: 10px;
      border: none;
      width: 30%;
      height: 35px;
      font-size: 12px;
    }
</style>