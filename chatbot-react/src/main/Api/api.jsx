
const axios = require("axios");

export const storeCode = {
    storeCodeApi: (storeNum) =>
        axios.post(
            '/api/storecode',
            {
                storeNum: storeNum
            },
        )
        // .then(function (response) {
        //   console.log(response);
        // })
        // .catch(function (error) {
        //   console.log(error);
        // })
        ,
};