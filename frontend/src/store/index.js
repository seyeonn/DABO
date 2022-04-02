import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";
//import jwt_decode from "jwt-decode";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    accessToken: localStorage.getItem("accessToken"), // 토큰정보
    userInfo: null,
  },
  getters: {
    config: function (state) {
      return {
        Authorization: `JWT ${state.accessToken}`,
      };
    },
    // 로그인 했는지 확인
    isLogin: function (state) {
      return !!state.accessToken;
    },
    getAccessToken: function (state) {
      return state.accessToken;
    },
    getUserNumber: function (state) {
      return state.userInfo.userNumber;
    },
    getUserInfo: function (state) {
      return state.userInfo;
    },
    getUserNickName: function () {
      return localStorage.getItem("nickName");
    },
  },
  mutations: {
    SET_LOGIN: function (state, accessToken) {
      axios({
        method: "get",
        url: `http://localhost:8080/api/user/me`,
        headers: {
          Authorization: `Bearer ` + accessToken,
        },
      }).then((response) => {
        state.userInfo = response.data;
      });
      //let decode_token = jwt_decode(accessToken);

      //console.log(decode_token);
      //state.userInfo = decode_token.loginUser;

      state.accessToken = accessToken;
      state.isLogin = true;

      localStorage.setItem("accessToken", accessToken);
    },
    SET_LOGOUT: function (state) {
      state.accessToken = null;
      state.isLogin = false;
      state.myuserNumber = null;
      state.userInfo = null;
      localStorage.removeItem("accessToken");
      localStorage.removeItem("nickName");

      location.reload();
    },
    SET_NICKNAME: function (state, nickname) {
      state.userInfo.userNickName = nickname;
    },
  },
  actions: {
    loginGetToken: function ({ commit }, token) {
      commit("SET_LOGIN", token);
    },
    logoutRemoveToekn: function ({ commit }) {
      commit("SET_LOGOUT");
    },
    nicknameRenew({ commit }, nickname) {
      commit("SET_NICKNAME", nickname);
    },
  },
  modules: {},
});
