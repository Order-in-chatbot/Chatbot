package com.project.chatbot.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.chatbot.dao.StoreDAO;
import com.project.chatbot.dao.StoreDAO;
import com.project.chatbot.domain.StoreVO;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Resource
	private StoreDAO storeDAO;
	
	public StoreDAO getStoreDAO() {
		return storeDAO;
	}
	
	@Override
	public String storefind(int storeno){
		return storeDAO.storefind(storeno);
	}

	@Override
	public List<StoreVO> list(){
		return storeDAO.list();
	}
	
	@Override
	public String event(int storeno) {
		return storeDAO.event(storeno);
	}
}
