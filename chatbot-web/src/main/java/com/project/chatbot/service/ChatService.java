package com.project.chatbot.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import com.project.chatbot.dao.ChatDao;

@Service
public class ChatService {
	private static final ChatDao chatDao = new ChatDao();

	//@SuppressWarnings("unchecked")
	public Map<String, Object> open() {
		String json = chatDao.open();
		ObjectMapper mapper = new ObjectMapper();
	
		Map<String, Object> res = new HashMap<String, Object>();
		try {
//			Map<String, Object> map = mapper.readValue(json, Map.class);		
//			Map<String, Object> return_object = (Map<String, Object>) map.get("return_object");
//			Map<String, Object> result = (Map<String, Object>) return_object.get("result");
//			
//			String text = (String) result.get("system_text");
//			String uuid = (String) return_object.get("uuid");
//			
//			Map<String, Object> submap = new HashMap<String, Object>();
//			submap.put("id", "user");
//			
//			res.put("id", "chatbot");
//			res.put("uuid",uuid);
//			res.put("text",text);
//			res.put("createdAt", new Date());
//			res.put("user", submap);
			//api을 쓸수 있는 형식으로 만들어 주는 과정
			//@SuppressWarnings("unchecked")
			Map<String,Object> map=mapper.readValue(json, Map.class);
			System.out.println(map);

			Map<String,Object> return_object=(Map) map.get("return_object");
			System.out.println(return_object);

			String uuid=(String) return_object.get("uuid");

			Map<String,Object>result=(Map<String, Object>) return_object.get("result");
			String text=(String) result.get("system_text");

			//Map<String,Object>submap=new HashMap<String, Object>();
			//submap.put("id", "user");

			//res.put("id","chatbot");
			res.put("position", "left");
			res.put("type", "text");
			res.put("uuid",uuid);
			res.put("text",text);
			res.put("createdAt", new Date());
			//res.put("user",submap);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> message(Map<String, Object> data, HttpServletRequest servletReq) {	
		Map<String, Object> question = (Map<String, Object>) data.get("question");
		
		Map<String, String> req = new HashMap<String, String>();
		
		System.out.println(question);
		System.out.println(data);
		req.put("text", (String) question.get("text"));
		req.put("uuid", (String) data.get("uuid"));
		System.out.println(req);
		//String folderName = servletReq.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "tts";
		
		String json = chatDao.message(req);
		//System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Map<String, Object> map = mapper.readValue(json, Map.class);		
			Map<String, Object> return_object = (Map<String, Object>) map.get("return_object");
			Map<String, Object> result = (Map<String, Object>) return_object.get("result");
			//System.out.println(map);
			//System.out.println(return_object);
			//System.out.println(result);
			String text = (String) result.get("system_text");
			//String uuid = (String) return_object.get("uuid");
			
			Map<String, Object> submap = new HashMap<String, Object>();
			submap.put("id", "user");
			
			res.put("id", "chatbot");
			//res.put("uuid",uuid);
			res.put("text", removeTags(text));
			res.put("createdAt", new Date());
			res.put("user", submap);
			//res.put("ttsUrl", chatDao.tts(folderName,text));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}
	// html escape
	private String removeTags(String text) {
		return text.replace("<br>", "");
	}

}