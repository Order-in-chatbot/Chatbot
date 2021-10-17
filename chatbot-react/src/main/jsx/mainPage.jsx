import * as React from 'react';
import IconButton from '@mui/material/IconButton';
import './mainPageStyle.scss';
import { Grid } from '@mui/material';
import TextField from '@mui/material/TextField';
import ChatIcon from '@mui/icons-material/Chat';

const MainPage = ({ stCode, selectStore, handleStCode }) => {

    return (
        <div className="mainPage">
            <Grid className="center">
                <div>
                    <h1 style={{ fontSize: '7em' }}>오늘의<br/>식사를<br/>주문하세요</h1>
                </div>
                <Grid className="select">
                    <TextField required name='stCode' value={stCode} onChange={handleStCode}
                                id="filled-basic" label="키오스크 상단에 적힌 매장 코드를 입력해주세요."
                                variant="filled" style={{ width: '100%' }} />
                    <IconButton size="large" aria-label="이동" onClick={selectStore}
                                style={{ width: '36px', marginLeft: '10px' }}>
                        <ChatIcon sx={{ fontSize: 36 }} />
                    </IconButton>
                </Grid>
            </Grid>

        </div>
    );
};

export default MainPage;