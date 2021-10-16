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
	private StoreService storeService;
	
	@Autowired
	private OrderService orderService;
	
	
	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map<String, Object> open(@RequestBody Map<String, Object> data) {
		
		System.out.println(data);
		Integer storeNum = (int) data.get("storeNum");
		
	
		Map<String, Object> answer = new HashMap<String, Object>();
		
		String storename=storeService.storefind(storeNum);
		
		System.out.println(storename);
		
		String message = String.format("�ȳ��ϼ��� ���� ������ %s�Դϴ�..", storename);
		
		System.out.println(message);
		
		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", message);
		answer.put("date", new Date());
		
		//2���� ������??
		String event=orderService.bestmenufind(storeNum);
		System.out.println(event); 
		String message2 = String.format("������ �̺�Ʈ�� %s�Դϴ�..", event);
		
		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", message2);
		answer.put("date", new Date());
//		
		//return chatService.open();
		//service �κ� ���� Ȯ���ϱ�
		return answer;

	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		//Utils.stream(chatService.tts(data), res.getOutputStream());
		
		Map<String, Object> answer = new HashMap<String, Object>();
		
		
		Integer storeNum = (int) data.get("storeNum");
		
		String product = orderService.bestmenufind(storeNum); // chatService.getBestSeller();   //select productName, count(*) from product where storeNum = 1 group by productName limit 1; 
		String message = String.format("���� ���� �ȸ��� ��ǰ�� %s �Դϴ�.", product);
		
		System.out.println(data);
		Map question = (Map) data.get("question");
		
		if(question.get("text").equals("���� ���� �ȸ��� ��ǰ �˷���")) {
			answer.put("position", "left");
			answer.put("type", "text");
			answer.put("text", message);
			answer.put("date", new Date());
		} else {
			answer = ChatService.message(data, req);
		}
		
		return answer;
		
		//�Ѿ�� �κ�???????
	}

}
