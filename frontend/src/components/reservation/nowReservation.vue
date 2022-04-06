<template>
    <div>
        <div class="dabo_header">
            <h2 class="dabo_title">헌혈의 집 예약</h2>
        </div>
        <div class="nowReservation-page">
            <form class="form" @submit.prevent="submitForm">
            <h4 class="h-p">예약 현황</h4>
            <p>선택하신 헌혈의 집으로 예약을 도와드립니다.</p>

            <div class="donationList">
                <p>{{ bloodHouse.housename }}</p>
                <p>주소 : {{ bloodHouse.address }}</p>
                <p>전화번호 : {{ bloodHouse.telephone }}</p>
            </div>

            <p class="p_res">날짜 지정</p>
            <input type="date" name="blood_date" id="blood_date" v-model="blood_date">

            <p class="p_res">시간 선택</p>
            <input type="time" name="blood_time" id="blood_time" v-model="blood_time">

            <p class="p_res">헌혈 종류 선택</p>
            <input type="radio" class="blood_type" name="blood_type" value="전혈" v-model="blood_type">전혈
            <input type="radio" class="blood_type" name="blood_type" value="혈장" v-model="blood_type">혈장
            <input type="radio" class="blood_type" name="blood_type" value="혈소판" v-model="blood_type">혈소판
            <input type="radio" class="blood_type" name="blood_type" value="혈장 + 혈소판" v-model="blood_type">혈장+혈소판
            
            <button class="btn_red" type="submit" >
                <span>예약하기</span>
            </button>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import {API_BASE_URL} from "@/config/index.js"

export default {
    data() {
        return {
            bloodHouse: [],
            housename: '',
            address: '',
            telephone: '',
            bloodHouseId: 0,
            blood_date: '',
            blood_time: '',
            blood_type: '',
            reservation: [],
        }
    },
    async created() {
        // 헌혈의 집 내용 get
        axios
        .get(API_BASE_URL+`/api/reservation/nowReservation/${this.$route.params.bloodHouseId}`)
        .then((res) => {
          this.bloodHouse = res.data;
        });
    },
    methods: {
        async submitForm() {
            //console.log(this.bloodHouse.housename);
            console.log(this.blood_date.toString());
            const reservation = {
                housename: this.bloodHouse.housename,
                address: this.bloodHouse.address,
                telephone: this.bloodHouse.telephone,
                bloodDate: this.blood_date.toString(),
                bloodTime: this.blood_time.toString(),
                bloodType: this.blood_type,
            };

            console.log(reservation);

            await axios.post(API_BASE_URL + `/api/reservation/reservationBloodHouse`, reservation, {
                headers: {
                    Authorization: `Bearer `+ localStorage.getItem("accessToken"),
                    }
                })
                .then((res) => {
                this.reservation = res.data;
                console.log(reservation);
                this.$router.push({name: 'reservationHistory', params: {reservation: reservation}})
                });
        }
    }
}
</script>

<style>
.nowReservation-page {
  margin: 0 auto;
  width: 90%;
}
.p_res {
    margin-bottom: 5px;
    margin-top:15px;
}
.blood_type {
    margin-right: 7px;
    margin-left: 5px;
}
</style>