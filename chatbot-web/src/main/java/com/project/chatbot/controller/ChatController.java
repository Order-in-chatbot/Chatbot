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
//		//db에 저장된 지점코드랑 num이랑 일치하는지 확인해서 DB에서 select해온뒤
//		//storeName에 저장
//		
//		if(storeNum == 1) {
//			message = "어서오세요  서울지점 입니다.";
//		}
//		else if(storeNum == 2){
//			message = "어서오세요 경기지점 입니다.";
//		} else {
//			message = "잘못된 지점 번호 입니다.";
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
//		String product = "빅맥"; // chatService.getBestSeller();   //select productName, count(*) from product where storeNum = 1 group by productName limit 1; 
//		String message = String.format("가장 많이 팔리는 제품은 %s 입니다.", product);
//		
//		System.out.println(data);
//		Map question = (Map) data.get("question");
//		
//		if(question.get("text").equals("가장 많이 팔리는 제품 알려줘")) {
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
