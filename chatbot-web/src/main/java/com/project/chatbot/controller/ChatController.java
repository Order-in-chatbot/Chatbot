//package com.project.chatbot.controller;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.project.chatbot.service.ChatService;
//
//@RestController
//public class ChatController {
//	
//	@Autowired ChatService chatService;	
//		
//	@CrossOrigin("*")
//	@PostMapping(value = "/chat/open")
//	public Map<String, Object> open(@RequestBody Map<String, Object> data) {
//		
//		System.out.println(data);
//		Integer storeNum = (int) data.get("num");
//		
//		Map<String, Object> answer = new HashMap<String, Object>();
//		String message = "";
//		
//		//String storeName = chatService.getStoreInfo(storeNum);
//		//db�� ����� �����ڵ�� num�̶� ��ġ�ϴ��� Ȯ���ؼ� DB���� select�ؿµ�
//		//storeName�� ����
//		
//		if(storeNum == 1) {
//			message = "�������  �������� �Դϴ�.";
//		}
//		else if(storeNum == 2){
//			message = "������� ������� �Դϴ�.";
//		} else {
//			message = "�߸��� ���� ��ȣ �Դϴ�.";
//		}
//		
//		answer.put("position", "left");
//		answer.put("type", "text");
//		answer.put("text", message);
//		answer.put("date", new Date());
//		
//		//return chatService.open();
//		return answer;
//	}
//	
//	@CrossOrigin("*")
//	@PostMapping(value = "/chat/message")
//	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
//		//Utils.stream(chatService.tts(data), res.getOutputStream());
//		
//		Map<String, Object> answer = new HashMap<String, Object>();
//		
//		String product = "���"; // chatService.getBestSeller();   //select productName, count(*) from product where storeNum = 1 group by productName limit 1; 
//		String message = String.format("���� ���� �ȸ��� ��ǰ�� %s �Դϴ�.", product);
//		
//		System.out.println(data);
//		Map question = (Map) data.get("question");
//		
//		if(question.get("text").equals("���� ���� �ȸ��� ��ǰ �˷���")) {
//			answer.put("position", "left");
//			answer.put("type", "text");
//			answer.put("text", message);
//			answer.put("date", new Date());
//		} else {
//			answer = chatService.message(data, req);
//		}
//		
//		
//		return answer;
//	}
//}
