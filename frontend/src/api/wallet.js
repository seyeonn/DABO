import { createInstance } from "./index.js";
import { BLOCKCHAIN_URL } from "../config/index.js";
import Web3 from "web3";

const instance = createInstance();

function findAddressById(id, success, fail) {
  instance
    .get("/api/wallets/of/" + id)
    .then(function(response) {
      success(response.data["address"]);
    })
    .catch(fail);
}

function findByUserId(id, success, fail) {
  instance
    .get("/api/wallets/of/" + id)
    .then(success)
    .catch(fail);
}

function isValidPrivateKey(userId, privateKey, success) {
  var web3 = new Web3(new Web3.providers.HttpProvider(BLOCKCHAIN_URL));
  var account = web3.eth.accounts.privateKeyToAccount(privateKey);

  findByUserId(userId, function(response) {
    var address = response.data["address"];
    success(account && account.address == address);
  });
}

function registerWallet(userId, walletAddress, success, fail) {
  const body = {
    ownerId: userId,
    address: walletAddress
  };

  instance
    .post("/api/wallets", JSON.stringify(body))
    .then(success)
    .catch(fail);
}

function chargeEther(walletAddress, success, fail) {
  instance
    .put("/api/wallets/" + walletAddress)
    .then(success)
    .catch(fail);
}
function createDonation(body, success, fail){
  console.log("createDonation API START")
  console.log(body)
  instance
    .post("/api/wallets/donation", JSON.stringify(body))
    .then(success)
    .catch(fail);
}

function getDonationByAddress(address, success, fail){
  console.log("getDonationByAddress API START")
  instance
    .get("/api/wallets/donation/of/"+address)
    .then(success)
    .catch(fail);
}


export {
  findAddressById,
  findByUserId,
  registerWallet,
  isValidPrivateKey,
  chargeEther,
  createDonation,
  getDonationByAddress
};

