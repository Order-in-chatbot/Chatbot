package com.project.chatbot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.chatbot.domain.StNumVO;
import com.project.chatbot.service.ChatService;
import com.project.chatbot.service.OrderService;
import com.project.chatbot.service.StoreService;

@Controller
public class ChatController {

	private final StoreService storeService;
	private final OrderService orderService;
	private final ChatService chatService;

	public ChatController(StoreService storeService, OrderService orderService, ChatService chatService) {
		this.storeService = storeService;
		this.orderService = orderService;
		this.chatService = chatService;
	}

	

	@CrossOrigin("*")
	@PostMapping(value = "/chat/open")
	public Map<String, Object> open(@RequestBody Map<String, Object> data) {

		System.out.println(data);
		Integer storeNum = (int) data.get("storeNum");

		Map<String, Object> answer = new HashMap<String, Object>();

		String storename = storeService.storefind(storeNum);
		String event = orderService.bestmenufind(storeNum);

		String message = String.format("안녕하세요 저희 지점은 %s입니다..", storename);
		String message2 = String.format("오늘의 이벤트는 %s입니다..", event);

		String f_message = message.concat(message2);

		answer.put("position", "left");
		answer.put("type", "text");
		answer.put("text", f_message);
		answer.put("date", new Date());

		return chatService.open();

	}

	@CrossOrigin("*")
	@PostMapping(value = "/chat/message")
	public Map message(@RequestBody Map<String, Object> data, HttpServletRequest req) throws IOException {
		// Utils.stream(chatService.tts(data), res.getOutputStream());

		Map<String, Object> answer = new HashMap<String, Object>();

		Integer storeNum = (int) data.get("storeNum");

		String product = orderService.bestmenufind(storeNum);
		String message = String.format("가장 많이 팔리는 제품은 %s 입니다.", product);

		System.out.println(data);
		Map question = (Map) data.get("question");

		if (question.get("text").equals("가장 많이 팔리는 제품 알려줘")) {
			answer.put("position", "left");
			answer.put("type", "text");
			answer.put("text", message);
			answer.put("date", new Date());
		} else {
			answer = chatService.message(data, req);
		}

		return answer;
	}

}