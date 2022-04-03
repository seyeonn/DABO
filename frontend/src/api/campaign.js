import { createInstance } from "./index.js";

const instance = createInstance();

function listBoard(body, response, fail) {
    instance
      .get("/donationBoard/listBoard")
      .then(response)
      .catch(fail);
  }

  export { listBoard };