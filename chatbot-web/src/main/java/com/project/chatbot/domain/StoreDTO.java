package com.project.chatbot.domain;

public class StoreDTO {
	private int storeno;
	private String storename;
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	@Override
	public String toString() {
		return "StoreVO [storeno=" + storeno + ", storename=" + storename + "]";
	}
	
	

}
