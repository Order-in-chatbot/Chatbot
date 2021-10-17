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

	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map<String, Object> open(@RequestBody Map<String, Object> data) {
		
		System.out.println(data);
		Integer storeNum = (int) data.get("storeNum");
		
		Map<String, Object> answer = new HashMap<String, Object>();
		
		String storename=storeService.storefind(storeNum);
		String event=storeService.event(storeNum);
		
		String message = String.format("�ȳ��ϼ��� ���� ������ %s�Դϴ�.\n", storename);
		String message2 = String.format("���� �����ϴ� �̺�Ʈ�� %s�Դϴ�.\n", event);	
		
		String f_message=message.concat(message2);
		
		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", f_message);
		answer.put("date", new Date());
		
		//return ChatService.open();
		//service �κ� ���� Ȯ���ϱ�
		return answer;

	}
	
	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		//Utils.stream(chatService.tts(data), res.getOutputStream());
		
		Map<String, Object> answer = new HashMap<String, Object>();
	
		//data���� storeno���� �����ͼ� �� �� �ֳ�??
		//storeNum�� ��������� ������ �� �ִ� ����� ã�ƾ��Ѵ�.
		//System.out.println(data);
		//Integer storeNum = (int) data.get("storeNum");
		
		//String product = storeService.event(storeNum); 
		//String message = String.format("���� ���� �ȸ��� ��ǰ�� %s �Դϴ�.", product);
		
		System.out.println(data);
		Map question = (Map) data.get("question");
		
		if(question.get("text").equals("���� ���� �ȸ��� ��ǰ �˷���")) {
			answer.put("position", "left");
			answer.put("type", "text");
			//answer.put("text", message);
			answer.put("date", new Date());
		} else {
			answer = ChatService.message(data, req);
		}
		
		return answer;
		
		//�Ѿ�� �κ�???????
	}
	

}
