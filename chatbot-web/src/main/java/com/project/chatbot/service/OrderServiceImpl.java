package com.project.chatbot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.chatbot.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderDAO orderDAO;
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}
	
	@Override
	public String bestmenufind(int storeno) {
		return orderDAO.bestmenufind(storeno);
	}

}
