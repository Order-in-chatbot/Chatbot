package com.project.chatbot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.chatbot.domain.StoreVO;

public interface StoreService {
	
	
	public abstract String storefind(int storeno);
	public abstract List<StoreVO> list();

}
