package com.project.chatbot.controller;

import java.util.Scanner;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.chatbot.domain.StoreVO;
import com.project.chatbot.service.OrderService;
import com.project.chatbot.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/storelist")
	@ResponseBody
	public String storelist() {
		return storeService.list().toString();
	}
	
	@RequestMapping(value="/storefind")
	public String storefind() {
		System.out.println("input :");
		Scanner scanner=new Scanner(System.in);
		int storeno=scanner.nextInt();
		System.out.println(storeService.storefind(storeno));
		return storeService.storefind(storeno).toString();
	}
	
	@RequestMapping(value="/bestmenu")
	public String bestmenu() {
		System.out.println("storeno:");
		Scanner scanner=new Scanner(System.in);
		int storeno=scanner.nextInt();
		System.out.println(orderService.bestmenufind(storeno));
		return orderService.bestmenufind(storeno).toString();
		
	}
	
	@RequestMapping(value="/event")
	public String event() {
		System.out.println("storeno:");
		Scanner scanner=new Scanner(System.in);
		int storeno=scanner.nextInt();
		System.out.println(storeService.event(storeno));
		return storeService.event(storeno).toString();
		
	}

}