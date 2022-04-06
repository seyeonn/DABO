<template>
  <div>
    <div class="dabo_header">
      <h2 class="dabo_title">헌혈의 집 예약</h2>
    </div>
    <div class="bloodHouse-page">
      <!-- <h4 class="h-p">헌혈의 집 검색</h4>
      <p>우리집 주변의 헌혈의 집을 찾아보세요.</p> -->
      <div class="submit-form">
        <div class="input-check d-flex">
        <input 
        type="text" 
        name="bloodhouse" 
        id="bloodhouse" 
        v-model="keyword"
        placeholder="blood house search" />
        <button class="btn_red col-2" @click="goSearch()">
            <span>search</span>
          </button> 
          </div>
      </div>
      <div>
        <div class="container">
          <house-list-item 
          v-for="bloodHouse in bloodHouseList"
          :key="bloodHouse.id"
          v-bind="bloodHouse"
          />
        </div>
      </div>
      
    <!-- <section class="test"> -->
      <div id="map"></div>
    <!-- </section> -->
    </div>
  </div>
</template>


<script>
import HouseListItem from "@/components/reservation/houseListItem.vue";
import axios from "axios";
import { API_BASE_URL } from "@/config/index.js";

export default {
  data() {
    return {
      map: null,
      markers: [],
      latitude: 0,
      longitude: 0,
      bloodHouseList: [],
      keyword: ""
    }
  },
  async created() {
    if (!("geolocation" in navigator)) {
      return;
    }

    // get position
    navigator.geolocation.getCurrentPosition(pos => {
      this.latitude = pos.coords.latitude;
      this.longitude = pos.coords.longitude;

      if (window.kakao && window.kakao.maps) {

        this.initMap();

      } else {
        const script = document.createElement("script");
        /* global kakao */
        script.onload = () => kakao.maps.load(this.initMap);
        script.src = "https://j6b1061.p.ssafy.io/dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=408674fc88231a4d61801f16ed1fba1b";
        document.head.appendChild(script);
      }

    }, err => {
      alert(err.message);
    })

    // 헌혈의 집 불러오기
    const response = await axios
      .get(API_BASE_URL + "/api/reservation/bloodHouseList")
      .then((res) => {
        console.log(res.data);
        this.bloodHouseList = res.data;
      });
    console.log(response);
  },
  components: {
      HouseListItem
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
      this.displayMarker([[this.latitude, this.longitude]]);
    },
    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
          (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
            (position) =>
                new kakao.maps.Marker({
                  map: this.map,
                  position,
                })
        );

        const bounds = positions.reduce(
            (bounds, latlng) => bounds.extend(latlng),
            new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
    goSearch() {
      // 헌혈의 집 list
      const response = axios
        .get(API_BASE_URL+"/api/reservation/search", {
          params: {
            keyword: this.keyword
          }
        })
        .then((res) => {
          console.log(res.data);
          this.bloodHouseList = res.data;
        });
      console.log(response);
    }
  }
}
</script>


<style scoped>
.bloodHouse-page {
  margin: 0 auto;
  width: 90%;
}
/* .test {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
} */

#map {
  width: 320px;
  height: 400px;
  border: 1px #a8a8a8 solid;
}


</style>