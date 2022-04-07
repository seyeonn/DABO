import { tokenInstance } from "./tokenIndex.js";

const instance = tokenInstance();

function findByBloodCard(success, fail){
    console.log("findByBloodCard START")
    instance
    .get("api/bc/search")
    .then(function(response){
        success(response);
    })
    .catch(fail);
}

function bloodCardChageState(body, success, fail){
    instance
    .post("api/bc/donation", JSON.stringify(body))
    .then(success)
    .catch(fail);
}

function createBloodCard(body, success, fail){
    instance
    .post("api/bc/create", JSON.stringify(body))
    .then(success)
    .catch(fail);
}

function thSendBloodCard(success, fail){
    instance
    .get("api/bc/transactionHistory/send")
    .then(success)
    .catch(fail);
}

export{
    findByBloodCard,
    bloodCardChageState,
    createBloodCard,
    thSendBloodCard
}