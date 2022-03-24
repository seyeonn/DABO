<template>
    <div class="nowReservation-page">
        <h4>예약 현황</h4>
        <p>선택하신 헌혈의 집으로 예약을 도와드립니다.</p>

        <div class="donationList">
        <p>헌혈의 집 이수센터</p>
        <p>주소 : 서울특별시 동작구 동작대로 109 경문빌딩 3층</p>
        <p>전화번호 : 02-578-9811</p>
        </div>

        <p class="p_res">날짜 지정</p>
        <input type="date" name="" id="">

        <p class="p_res">시간 선택</p>
        <input type="time" name="" id="">

        <p class="p_res">헌혈 종류 선택</p>
        <input type="radio" class="blood_type" name="blood_type" value="">전혈
        <input type="radio" class="blood_type" name="blood_type" value="">혈장
        <input type="radio" class="blood_type" name="blood_type" value="">혈소판
        <input type="radio" class="blood_type" name="blood_type" value="">혈장+혈소판
        
        <button class="btn_red">
            <span>예약하기</span>
        </button>
    </div>
</template>

<script>
export default {

}
</script>

<style>
.nowReservation-page {
  margin: 0 auto;
  width: 85%;
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