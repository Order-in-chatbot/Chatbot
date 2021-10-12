package com.project.chatbot.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.chatbot.dao.StoreDAO;
import com.project.chatbot.dao.StoreDAOImpl;
import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;

@Service
public class StoreServiceImpl implements StoreService{
	
	private final StoreDAO storeDAO;
	
	@Inject
	public StoreServiceImpl(StoreDAO storeDAO) {
		this.storeDAO=storeDAO;
	}
	@Override
	public StoreVO storefind(StoreDTO storeDTO)throws Exception{
		return storeDAO.storefind(storeDTO);
	}

}
