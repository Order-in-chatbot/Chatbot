
package com.project.chatbot.dao;

import java.util.List;

import com.project.chatbot.domain.StoreVO;

public interface StoreDAO {

	public abstract String storefind(int storeno);
	public abstract List<StoreVO> list();
	public abstract String event(int storeno);

}