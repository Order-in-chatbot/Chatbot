
package com.project.chatbot.dao;

import java.util.List;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;

public interface StoreDAO {
	public abstract StoreVO storefind(int storeno);
	public abstract List<StoreVO> list();

}