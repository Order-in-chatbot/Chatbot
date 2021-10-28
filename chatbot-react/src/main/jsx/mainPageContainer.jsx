import React, { useState } from 'react';
import { useHistory } from "react-router-dom";
import { storeCode } from '../Api/api';
import MainPage from './mainPage';


const Main = () => {

    //TODO 버튼 클릭 시 매장별 챗봇 연결
    const history = useHistory();

    const [storeInfo, setStoreInfo] = useState({
        stCode: '',
    });


    const {stCode} = storeInfo;

    const handleStCode = e =>{
        console.log(e.target.value);
        const {name, value} =e.target;
        setStoreInfo({
            ...storeInfo,
            [name]:value
        });
    };
    
    const selectStore = () => {
        storeCode.storeCodeApi(stCode).then(r => {
            history.push({
                pathname: "/storechat",
                props: { stCode: stCode }
            })
        }).catch(e => {
            console.log(e.response);
        })
        // history.push({
        //     pathname: "/storechat",
        //     props: { stCode: stCode }
        // })
    };

    return (
        <div>
            <MainPage stCode={stCode} selectStore={selectStore} handleStCode={handleStCode}></MainPage>
        </div>
    );
};

export default Main;