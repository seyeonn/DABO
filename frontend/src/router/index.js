import Vue from "vue";
import VueRouter from "vue-router";
import landing from "@/views/landing/landingPage.vue";
import Home from "@/views/mainPage.vue";
import badge from "@/views/badge/badgeMain.vue";
import bloodCard from "@/views/bloodCard/bloodCardCreate.vue";
import daboWallet from "@/views/daboWallet/daboWalletMain.vue";

import donationBoard from "@/views/donationBoard/donationBoardPage.vue";
import ListBoard from "@/components/campaign/donationBoardList.vue";
import ListItem from "@/components/campaign/donationBoardListItem.vue";
import CreateBoard from "@/components/campaign/donationBoardCreate.vue";
import DetailBoard from "@/components/campaign/donationBoardDetail.vue";
import MyDonation from "@/components/campaign/myDonationDetail.vue";
import DonationConfirm from "@/components/campaign/donationConfirm.vue";
import DaboDonation from "@/components/campaign/daboDonation.vue";
import DaboConfirm from "@/components/campaign/daboConfirm.vue";

import reservation from "@/views/reservation/reservationMain.vue";
import SearchMap from "@/components/reservation/searchMap.vue";
import NowReservation from "@/components/reservation/nowReservation.vue";
import ReservationHistory from "@/components/reservation/reservationHistory.vue";

import user from "@/views/user/userPage.vue";
import Login from "@/components/user/loginPage.vue";
import Signup from "@/components/user/signUp.vue";
import infoChange from "@/components/user/infoChange.vue";
import Ranking from "@/components/user/rankingDetail.vue";
import myDabo from "@/views/user/myDabo.vue";
import chargeDabo from "@/views/daboWallet/chargeDabo";

import Findpassword from "@/components/user/findPassword.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "landing",
    component: landing,
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
  {
    path: "/user",
    name: "user",
    component: user,
    children: [
      {
        path: "login",
        name: "login",
        component: Login,
      },
      {
        path: "signup",
        name: "signup",
        component: Signup,
      },
      {
        path: "findpassword",
        name: "findpassword",
        component: Findpassword,
      },
      {
        path: "infochange",
        name: "infoChange",
        component: infoChange,
      },
      {
        path: "ranking",
        name: "ranking",
        component: Ranking,
      },
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: reservation,
    children: [
      {
        path: "searchMap",
        name: "searchMap",
        component: SearchMap,
      },
      {
        path: "nowReservation",
        name: "nowReservation",
        component: NowReservation,
      },
      {
        path: "reservationHistory",
        name: "reservationHistory",
        component: ReservationHistory,
      },
    ],
  },
  {
    path: "/donationboard",
    name: "donationBoard",
    component: donationBoard,
    children: [
      {
        path: "listBoard",
        name: "listBoard",
        component: ListBoard,
      },
      {
        path: "listItem",
        name: "listItem",
        component: ListItem,
      },
      {
        path: "createBoard",
        name: "createBoard",
        component: CreateBoard,
      },
      {
        path: "detailBoard",
        name: "detailBoard",
        component: DetailBoard,
      },
      {
        path: "myDonation",
        name: "myDonation",
        component: MyDonation,
      },
      {
        path: "donationConfirm",
        name: "donationConfirm",
        component: DonationConfirm,
      },
      {
        path: "daboDonation",
        name: "daboDonation",
        component: DaboDonation,
      },
      {
        path: "daboConfirm",
        name: "daboConfirm",
        component: DaboConfirm,
      },
    ],
  },
  {
    path: "/dabowallet",
    name: "daboWallet",
    component: daboWallet,
    children: [
      {
        path: "chargedabo",
        name: "chargeDabo",
        component: chargeDabo,
      },
    ]
  },
  {
    path: "/bloodcard",
    name: "bloodCard",
    component: bloodCard,
  },
  {
    path: "/badge",
    name: "badge",
    component: badge,
  },
  {
    path: "/landing",
    name: "landing",
    component: landing,
  },
  {
    path: "/mydabo",
    name: "myDabo",
    component: myDabo,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
