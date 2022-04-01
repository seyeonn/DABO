<template>
  <div class="donationBoard-page">
    <div class="dabo_header">
      <h2 class="dabo_title">캠페인 목록</h2>
    </div>
    
    <!-- 검색창 -->
    <div class="submit-form">
      <div class="input-check d-flex">
      <input type="text" name="campaign" id="campaignSearch" placeholder="campaign search">
      <button class="btn_red col-2" @click="goCreata()">
          <span>search</span>
        </button>
        </div>
    </div>
    <div>
      <!-- <div v-for="(campaign, idx) in campaignList" :key="idx">
        <CampaignListItem
        :campaign="campaign" />
      </div> -->
      <div class="container">
        <div class="campaign_item">
        <div class="row" @click="goDetail()">
            <div class="col-4">
              <img src="https://i.imgur.com/httN9Bm.png" class="campaign-img" alt="">
            </div>
            <div class="col-8">
              <h4>캠페인 이름</h4>
              <p style="margin-bottom: 0px">캠페인 내용</p>
                <div>
                  <div class="small font-weight-bold">
                    <span class="ratio">20%</span> 
                    <span class="float-right" style="margin-left: 5px; margin-right:60px;">5명</span>
                    <span class="float-right">15일 남음</span>
                    </div>
                      <div class="progress mb-2">
                        <div class="progress-bar bg-danger" role="progressbar" style="width: 20%"
                                    aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                </div>
            </div>
          </div>
        </div>  

        <div class="campaign_item">
        <div class="row">
            <div class="col-4">
              <img src="https://i.imgur.com/httN9Bm.png" class="campaign-img" alt="">
            </div>
            <div class="col-8">
              <h4>기부가 필요해요!</h4>
              <p style="margin-bottom: 0px">기부 해주세요</p>
                <div>
                  <div class="small font-weight-bold">
                    <span class="ratio">30%</span> 
                    <span class="float-right" style="margin-left: 5px; margin-right:60px;">5명</span>
                    <span class="float-right">10일 남음</span>
                    </div>
                      <div class="progress mb-2">
                        <div class="progress-bar bg-danger" role="progressbar" style="width: 30%"
                                    aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                </div>
            </div>
          </div>
        </div>  
        </div>
    </div>
  </div>

</template>

<script>
//import CampaignListItem from '@/components/campaign/CampaignListItem'
export default {
  name: 'donationBoardList', 
  data: function() {
    return {
      campaignList: [],
    }
  },
  components: {
    //CampaignListItem
  },
  methods: {
    goDetail() {
      this.$router.push({name: 'detailBoard', params: ''})
    },
    goCreata() {
      this.$router.push({name: 'createBoard', params: ''})
    }
  }
};
</script>

<style>
.signup-page {
  text-align: -webkit-center;
  margin: 0 auto;
  width: 70%;
  font-weight: bold;
}
.dabo_header {
  background-color: #e52d27;
  text-align: center;
  height: 24vh;
}
.dabo_title {
  padding-top: 10vh;
  color: white;
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

.input-bloodtype span {
  margin-top: 5%;
  font-size: 12px;
  float: left;
}
.campaign-img {
  width: 110px;
  height: 110px;
}
.ratio {
  color:#e52d27;
  font-size: 20px;
  font-weight: 3px;
  margin-right: 10px;
}
.span_day {
  float:right;
  position: absolute;
  margin-left: 100px;
}
.campaign_item {
  border: 1px solid #e8e8e8;
  border-radius: 8px;
  padding: 10px;
  margin-bottom: 5px;
}
</style>