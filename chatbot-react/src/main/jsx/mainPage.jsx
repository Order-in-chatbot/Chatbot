import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import IconButton from '@mui/material/IconButton';
import ChatIcon from '@mui/icons-material/Chat';
import { useHistory } from "react-router-dom";
import { Grid } from '@mui/material';
import './mainPageStyle.scss';

const Main = () => {

    //TODO 버튼 클릭 시 매장별 챗봇 연결
    const history = useHistory();

    const [nnn, setNnn] = React.useState('');
    const restNum = (num) => {
        console.log(num);
        setNnn(num);
        console.log(nnn);
    };

    const [restaurant, setRestaurant] = React.useState('');
    const handleChange = (event) => {
        setRestaurant(event.target.value);
        restNum(event.target.value);
    };

    const selectStore = (num) => {
        if (num === 1) {
            history.push({
                pathname: "/mcdonalds",
                props: { num: num }
            });
        }
        else if (num === 2) {
            history.push({
                pathname: "/mcdonalds",
                props: { num: num }
            });
        }
        else {
            history.push({
                pathname: "/mcdonalds",
                props: { num: num }
            });
        }
    };

    //항상return
    return (
        //html 코드
        <div className="mainPage">
            <Grid className="center">
                <div>
                    <h1 style={{ fontSize: '8em' }}>Order your Meal</h1>
                </div>
                <Grid className="select">
                    <FormControl variant="filled" style={{ width: '50%' }}>
                        <InputLabel id="demo-simple-select-filled-label">주문하실 매장을 선택해 주세요.</InputLabel>
                        <Select
                            labelId="demo-simple-select-filled-label"
                            id="demo-simple-select-filled"
                            value={restaurant}
                            label="restaurant"
                            onChange={handleChange}
                        >
                            <MenuItem value={1} >맥도날드 북수원 DT점</MenuItem>
                            <MenuItem value={2} >맥도날드 수원정자 DT점</MenuItem>
                            <MenuItem value={3} >맥도날드 안양점</MenuItem>

                        </Select>
                    </FormControl>
                    <IconButton size="large" aria-label="이동" onClick={() => selectStore(nnn)}><ChatIcon sx={{ fontSize: 36 }} /></IconButton>
                </Grid>
            </Grid>
        </div>

    );
};

export default Main;