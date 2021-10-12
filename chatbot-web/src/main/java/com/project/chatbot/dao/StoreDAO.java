package com.project.chatbot.dao;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;

public interface StoreDAO {
	StoreVO storefind(StoreDTO storeDTO)throws Exception;

}
