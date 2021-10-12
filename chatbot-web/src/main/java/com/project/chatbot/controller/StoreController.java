package com.project.chatbot.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.chatbot.domain.StoreDTO;
import com.project.chatbot.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	private final StoreService storeService;
	
	@Inject
	public StoreController(StoreService storeService) {
		this.storeService=storeService;
	}
	
	@RequestMapping(value="/storefind",method=RequestMethod.GET)
		public String storeGET(@ModelAttribute("storeDTO") StoreDTO storeDTO) {
			System.out.println(storeDTO.getStorename());
			return "/store/storefind";
		}
	

}