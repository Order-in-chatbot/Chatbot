package com.project.chatbot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.chatbot.service.ChatService;
import com.project.chatbot.service.OrderService;
import com.project.chatbot.service.StoreService;

@RestController
public class ChatController {
	
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	ChatService chatService;

	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map<String, Object> open(@RequestBody Map<String, Object> data) {
		
		return chatService.open();
		//service 부분 보고 확인하기
		//return answer;

	}
	@CrossOrigin("*")
	@PostMapping(value = "/chat/store")
	public Map<String, Object> selectstore(@RequestBody Map<String, Object> data) {
		
		System.out.println("dsfsdf");
		Integer storeNum = (int) data.get("storeNum");
		
		Map<String, Object> answer = new HashMap<String, Object>();
		
		String storename=storeService.storefind(storeNum);
		String event=storeService.event(storeNum);
		
		String message = String.format("안녕하세요 저희 지점은 %s입니다.\n", storename);
		String message2 = String.format("현재 진행하는 이벤트는 %s입니다.\n", event);	
		
		//Map<String, Object> return_object = (Map<String, Object>) map.get("return_object");
		
		String f_message=message.concat(message2);
		//String uuid = (String) return_object.get("uuid");
		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", f_message);
		answer.put("date", new Date());
		
		return answer;

	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		//Utils.stream(chatService.tts(data), res.getOutputStream());
		
//		Map<String, Object> answer = new HashMap<String, Object>();
//	
//		//data에서 storeno값을 가져와서 할 수 있나??
//		//storeNum을 계속적으로 가져올 수 있는 방법을 찾아야한다.
//		System.out.println(data);
//		Integer storeNum = (int) data.get("storeNum");
//		
//		String product = storeService.event(storeNum); 
//		String message = String.format("가장 많이 팔리는 제품은 %s 입니다.", product);
//		
//		System.out.println(data);
//		Map question = (Map) data.get("question");
//		
//		if(question.get("text").equals("가장 많이 팔리는 제품 알려줘")) {
//			answer.put("position", "left");
//			answer.put("type", "text");
//			//answer.put("text", message);
//			answer.put("date", new Date());
//		} else {
//			answer = ChatService.message(data, req);
//		}
//		
//		return answer;
		return chatService.message(data, req);
	}	
}