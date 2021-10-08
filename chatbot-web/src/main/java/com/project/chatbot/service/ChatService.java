package com.project.chatbot.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.chatbot.dao.ChatDao;

public class ChatService {
	//@Autowired CacheUtils cache;
		private ChatDao chatDao=new ChatDao();
		
		public Map<String,Object> open() {
			String json = chatDao.open(); //map�������� return
			System.out.println(json);
			
			ObjectMapper mapper=new ObjectMapper();
			
			Map<String,Object> res=new HashMap();
			try {
				//api�� ���� �ִ� �������� ����� �ִ� ����
				@SuppressWarnings("unchecked")
				Map<String,Object> map=mapper.readValue(json, Map.class);
				System.out.println(map);
				
				Map<String,Object> return_object=(Map) map.get("return_object");
				System.out.println(return_object);
				
				String uuid=(String) return_object.get("uuid");
				
				Map<String,Object>result=(Map<String, Object>) return_object.get("result");
				String text=(String) result.get("system_text");
				
				Map<String,Object>submap=new HashMap<String, Object>();
				submap.put("id", "user");
				
				res.put("id","chatbot");
				res.put("uuid",uuid);
				res.put("text",text);
				res.put("createdAt", new Date());
				res.put("user",submap);
				res.put("ttsUrl",chatDao.tts(folderName,text));
				
				//System.out.println(res);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return res;
			
			//�̰͵� �����ϱ�
			//uuid:""
			//text:"�ȳ��ϼ���"
			//user:{id:"user"}
		}


		public Map message(Map<String, Object> data, HttpServletRequest servletReq) {
			//System.out.println(data);
			
			@SuppressWarnings("unchecked")
			Map<String,Object> question=(Map<String,Object>) data.get("question");

			
			Map<String,String> req=new HashMap<String,String>();
			req.put("text", (String) question.get("text"));
			req.put("uuid", (String) data.get("uuid"));
			
			String folderName=servletReq.getSession().getServletContext().getRealPath("/");s
			
			String json=chatDao.message(req);
			
			ObjectMapper mapper=new ObjectMapper();
			Map<String,Object> res=new HashMap();
			try {
				//api�� ���� �ִ� �������� ����� �ִ� ����
				@SuppressWarnings("unchecked")
				Map<String,Object> map=mapper.readValue(json, Map.class);
				System.out.println(map);
				
				Map<String,Object> return_object=(Map) map.get("return_object");
				System.out.println(return_object);
				
				String uuid=(String) return_object.get("uuid");
				
				Map<String,Object>result=(Map<String, Object>) return_object.get("result");
				String text=(String) result.get("system_text");
				
				Map<String,Object>submap=new HashMap<String, Object>();
				submap.put("id", "user");
				
				res.put("id","chatbot");
				res.put("uuid",uuid);
				res.put("text",text);
				res.put("createdAt", new Date());
				res.put("user",submap);
				
				//System.out.println(res);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			System.out.println(json);
			return res;
		}

	}
