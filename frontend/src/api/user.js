import { createInstance } from "./index.js";

const instance = createInstance();
// function signup(email, name, password, success, fail) {
//     const user = {
//       email: email,
//       name: name,
//       password: password
//     };

//     instance
//       .post("/api/users", JSON.stringify(user))
//       .then(success)
//       .catch(fail);
//   }

function loginAPI(body, success, fail) {
  instance
    .post("/api/user/login", JSON.stringify(body))
    .then(success)
    .catch(fail);
}
function getUserInfo( success, fail){
    const accessToken = localStorage.getItem("accessToken");
    console.log(accessToken)
    instance
    .get("/api/user/me", {
      headers: {
        Authorization:  `Bearer ${accessToken}`
      }
    }).then(success)
    .catch(fail);
}


export { loginAPI,getUserInfo };
