package com.project.chatbot.persistence;

import java.util.List;

import com.project.chatbot.doman.StoreVO;

public interface StoreDAO {
	
	public List<StoreVO> storelist() throws Exception;

}
