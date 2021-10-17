const axios = require("axios");

//TODO baseURL 수정 필요할 듯?
axios.defaults.baseURL = 'http://aiopen.etri.re.kr:8000/'

export const storeCode = {
    storeCodeApi: (storeNum) =>
        axios.post(
            '/api/storecode',
            {
                storeNum: storeNum
            },
        )
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        })
        ,
};