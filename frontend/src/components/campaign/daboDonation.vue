<template>
    <div class="daboDonation-page">
        <h4>기부 금액(DABO)</h4>
        <p>278 DABO 보유</p>

        <table class="dabo_table">
            <tr>
                <td>200 DABO</td>
                <td>400 DABO</td>
                <td>600 DABO</td>
            </tr>
            <tr>
                <td>800 DABO</td>
                <td>1000 DABO</td>
                <td @click="textbox">직접 입력</td>
            </tr>
        </table>
        <div id="dabo_input"></div>
        <div class="dabo-line"></div>
        <div>
            <h3>후원 기부 금액
                <span class="h3_span">200 DABO</span>
            </h3>
        </div>

        <div>
        <a href="#bDonation">
        <button class="btn_red_donation" @click="bloodDonation">
            <span>DABO 기부하기</span>
        </button>
        </a>
        </div>
        <div id="bDonation" class="modal-window">
            <div>
                    <p>200 DABO를 기부하시겠습니까?</p>
                    <sub>
                        <b-icon icon="exclamation-circle" style="width: 10px; height: 10px;"></b-icon>
                        DABO 기부는 일정 시간의 대기 시간을 가진 뒤 자동으로 전달됩니다.
                        전달 완료 후에는 취소하실 수 없으며, 관련 법령이 정하는 바에 따라 기부가 취소될 수 있습니다.
                    </sub>
                    <div>
                    <a href="#">
                        <button class="btn_red_cancel">
                            <span>취소하기</span>
                        </button>
                    </a>
                    <button class="btn_red_modal">
                        <span>기부하기</span>
                    </button>
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
    methods: {
        textbox() {
            document.getElementById("dabo_input").innerHTML 
            = '<input type="text" name="" id="" class="dir_text"> DABO <button class="btn_red_dabo"><span>save</span></button>'
        }
    }
}
</script>

<style>
.daboDonation-page {
  margin: 0 auto;
  width: 90%;
}
 .dabo_table {
    background-color: rgb(255, 246, 246);
    border-collapse: collapse;
    border: 1px solid rgb(255, 208, 208);
    width: 330px;
    height: 70px;
    text-align: center;
 }
 .dabo_table > tr {
     border: 2px solid rgb(255, 208, 208);
 }
 .dabo_table > tr > td {
     border: 2px solid rgb(255, 208, 208);
 }  
 .dabo_input {
     text-align: center;
 } 
 .dir_text {
     margin-left: 30px;
     margin-top: 10px;
 }
 .btn_red_dabo {
     background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 50px;
  height: 30px;
  font-size: 12px;
  margin-top: 10px;
 }
 .h3_span {
     color: #e52d27;
     font-weight: 3px;
     margin-left: 70px;
 }
 .dabo-line {
    border-top: 2px solid rgb(211, 211, 211);
    margin-top: 15px;
    margin-bottom: 15px;
 }
</style>