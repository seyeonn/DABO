<template>
<div  class="campaign_item" @click="goDetail()">
    <div class="col-4">
        <img :src="'http://localhost:8080'+mediaUrl" alt="">
    </div>
        <div class="col-8">
            
            <h4>{{ title }}</h4>
            <p>{{ content }}</p>
            <div>
                  <div class="small font-weight-bold">
                    <span class="ratio">20%</span> 
                    <span class="float-right" style="margin-left: 5px; margin-right:60px;"></span>
                    <span class="float-right">{{ dueDate }}일 남음</span>
                    </div>
                      <div class="progress mb-2">
                        <div class="progress-bar bg-danger" role="progressbar" style="width: 20%"
                                    aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                </div>
        </div>
    </div>
</template>

<script>
//import axios from 'axios';

export default {
    props: {
        campaignId: Number,
        title: String,
        content: String,
        mediaUrl: String,
        deadLine: String,
    },
    data() {
        return {
            campaign: [],
            dueDate: "",
        }
    },
    async created() { 
        // dueDate 받아오기
        this.setDueDate();
    },
    methods: {
        setDueDate(){
            const strDate = this.deadLine.split("-");
            const date = new Date(strDate[0],strDate[1]-1,strDate[2]);
            const today = new Date();
            this.dueDate = Math.ceil((date-today)/(1000*60*60*24));
        },
        goDetail() {
            this.$router.push({name: 'detailBoard', params: {campaignId: this.campaignId} })
        },
    }
}
</script>

<style>
    
</style>