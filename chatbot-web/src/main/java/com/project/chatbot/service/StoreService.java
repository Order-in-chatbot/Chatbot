package com.project.chatbot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;

public interface StoreService {
	StoreVO storefind(StoreDTO storeDTO)throws Exception;
}
