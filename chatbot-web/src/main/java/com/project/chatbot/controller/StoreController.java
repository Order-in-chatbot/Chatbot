package com.project.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.chatbot.service.OrderService;
import com.project.chatbot.service.StoreService;

@RestController
public class StoreController {
	private final StoreService storeService;
	private final OrderService orderService;

	public StoreController(StoreService storeService, OrderService orderService) {
		this.storeService = storeService;
		this.orderService = orderService;
	}
	
	
	@RequestMapping(value = "/storelist")
	@ResponseBody
	public String storelist() {
		return storeService.list().toString();
	}

	@RequestMapping(value = "/api")
	@GetMapping("/storeCode")
	public int storeNum(@RequestBody StNumVO stNumVO) {
		return stNumVO.getStoreNum();
	}

	@RequestMapping(value = "/storefind")
	public String storefind(StNumVO stNumVO) {
		return storeService.storefind(storeNum(stNumVO)).toString();
	}

	@RequestMapping(value = "/bestmenu")
	public String bestmenu(StNumVO stNumVO) {
		return orderService.bestmenufind(storeNum(stNumVO)).toString();

	}

	@RequestMapping(value = "/event")
	public String event(StNumVO stNumVO) {
		return storeService.event(storeNum(stNumVO)).toString();

	}
}
