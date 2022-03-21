import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import badge from "../views/badge/badgeMain.vue";
import bloodCard from "../views/bloodCard/bloodCardCreate.vue";
import daboWallet from "../views/daboWallet/daboWalletMain.vue";
import donationBoard from "../views/donationBoard/donationBoardCreate.vue";
import ranking from "../views/ranking/rankingMain.vue";
import reservation from "../views/reservation/reservationMain.vue";
import user from "../views/user/signUp.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/",
    name: "user",
    component: user,
  },
  {
    path: "/",
    name: "reservation",
    component: reservation,
  },
  {
    path: "/",
    name: "ranking",
    component: ranking,
  },
  {
    path: "/",
    name: "donationBoard",
    component: donationBoard,
  },
  {
    path: "/",
    name: "daboWallet",
    component: daboWallet,
  },
  {
    path: "/",
    name: "bloodCard",
    component: bloodCard,
  },
  {
    path: "/",
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
