package com.project.chatbot.domain;

public class StoreDTO {
	private int storeno;
	private boolean useCookie;
	
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "StoreDTO [storeno=" + storeno + ", useCookie=" + useCookie + "]";
	}
	
	
}
