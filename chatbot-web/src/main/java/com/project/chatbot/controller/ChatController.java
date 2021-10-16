package com.project.chatbot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map<String, Object> open(@RequestBody Map<String, Object> data) {
		
		System.out.println(data);
		Integer storeNum = (int) data.get("storeNum");
		
		Map<String, Object> answer = new HashMap<String, Object>();
		
		String storename=storeService.storefind(storeNum);
		String event=orderService.bestmenufind(storeNum);
		
		String message = String.format("안녕하세요 저희 지점은 %s입니다..", storename);
		String message2 = String.format("오늘의 이벤트는 %s입니다..", event);	
		
		String f_message=message.concat(message2);
		
		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", f_message);
		answer.put("date", new Date());
		
		//return ChatService.open();
		//service 부분 보고 확인하기
		return answer;

	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		//Utils.stream(chatService.tts(data), res.getOutputStream());
		
		Map<String, Object> answer = new HashMap<String, Object>();
		
		Integer storeNum = (int) data.get("storeNum");
		
		String product = orderService.bestmenufind(storeNum); // chatService.getBestSeller();   //select productName, count(*) from product where storeNum = 1 group by productName limit 1; 
		String message = String.format("가장 많이 팔리는 제품은 %s 입니다.", product);
		
		System.out.println(data);
		Map question = (Map) data.get("question");
		
		if(question.get("text").equals("가장 많이 팔리는 제품 알려줘")) {
			answer.put("position", "left");
			answer.put("type", "text");
			answer.put("text", message);
			answer.put("date", new Date());
		} else {
			answer = ChatService.message(data, req);
		}
		
		return answer;
		
		//넘어가는 부분???????
	}

}
