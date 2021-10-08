package com.project.chatbot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.chatbot.service.ChatService;


//������ ����
@RestController
public class ChatController {
	
	private static final Logger logger=LoggerFactory.getLogger(ChatController.class);
	
	@Autowired ChatService chatService;
	
	@CrossOrigin("*")
	@PostMapping(value="/chat/open")
	public Map open(@RequestBody Map data) {
		
		String num=(String)data.get("num");
		
		if(num.equals("1"))
			System.out.println("��������");
		else 
			System.out.println("�������");

		//return chatService.open();
		
		//Map ���� ����
	}
	
	
	//��û�� ������ �޾ƶ�
	@CrossOrigin("*")
	//method�� post�̱� ������ postmapping
	@PostMapping(value="/chat/message") 
	//requestmapping�� ����ϱ�� ��
	//�� getmapping�ϸ� �� ���̰� ��
	public Map message(@RequestBody Map<String,Object>data,HttpServletRequest req) throws IOException{//Locale locale,Model model) {
		//logger.info("�޼��� �ҷ�����");
	
		//System.out.println(data);
		//�ڷᱸ�� map
		//Map map=new HashMap();
		
		//stt ����
		
		return chatService.message(data,req);

		
		/*
		 * Map submap=new HashMap();
		 * 
		 * map.put("id", "chatbot"); map.put("text", "�ȳ� ���� ê���̾�"); map.put("createdAt",
		 * new Date());
		 * 
		 * // user�� ����� �ٸ� ���̵���� �ٸ��� ���� //user : { // id:"user" //}
		 * submap.put("id","user"); //id:"user"���� //�ٽ� �ֱ� map.put("user",submap);
		 * 
		 * System.out.println(map);
		 * 
		 * //�ڹٿ����� �ν��ϴ� map���� //content-type�� ���� �ʴ� Ÿ������ ���ϵǾ 404���� //jsonŸ������ return
		 * -> pom���� �߰�
		 */		//return map;
	}

}