package com.project.chatbot.controller;

import java.util.Scanner;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.domain.StoreVO;
import com.project.chatbot.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value="/storelist")
	@ResponseBody
	public String storelist() {
		return storeService.list().toString();
	}
	
	@RequestMapping(value="/storefind", method=RequestMethod.GET)
	public String storefind() {
		System.out.println("input :");
		Scanner scanner=new Scanner(System.in);
		int storeno=scanner.nextInt();
		return storeService.storefind(storeno).toString();
	}
	

}