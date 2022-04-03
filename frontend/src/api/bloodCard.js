import { createInstance } from "./index.js";

const instance = createInstance();

function findByBloodCard(success, fail){
    instance
    .get("api/bc/search")
    .then(function(response){
        success(response);
    })
    .catch(fail);
}

function bloodCardChageState(bloodCardId, transactionCardMessage, transactionCardToId, success, fail){
    const body = {
        bloodCardId: bloodCardId,
        transactionCardMessage: transactionCardMessage,
        transactionCardToId: transactionCardToId
      };
    instance
    .post("api/bc/donation", JSON.stringify(body))
    .then(success)
    .catch(fail);
}
export{
    findByBloodCard,
    bloodCardChageState
}