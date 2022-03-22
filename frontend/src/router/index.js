import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/mainPage.vue";
import badge from "@/views/badge/badgeMain.vue";
import bloodCard from "@/views/bloodCard/bloodCardCreate.vue";
import daboWallet from "@/views/daboWallet/daboWalletMain.vue";
import donationBoard from "@/views/donationBoard/donationBoardCreate.vue";
import ranking from "@/views/ranking/rankingMain.vue";
import reservation from "@/views/reservation/reservationMain.vue";

import user from "@/views/user/userPage.vue";
import Login from "@/components/user/loginPage.vue";
import Signup from "@/components/user/signUp.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
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
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: reservation,
  },
  {
    path: "/ranking",
    name: "ranking",
    component: ranking,
  },
  {
    path: "/donationboard",
    name: "donationBoard",
    component: donationBoard,
  },
  {
    path: "/dabowallet",
    name: "daboWallet",
    component: daboWallet,
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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
