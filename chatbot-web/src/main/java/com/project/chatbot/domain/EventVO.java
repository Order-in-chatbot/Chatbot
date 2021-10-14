package com.project.chatbot.domain;

public class EventVO {
	private int storeno;
	private String eventtitle;
	private String eventcontent;
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public String getEventcontent() {
		return eventcontent;
	}
	public void setEventcontent(String eventcontent) {
		this.eventcontent = eventcontent;
	}
	@Override
	public String toString() {
		return "EventVO [storeno=" + storeno + ", eventtitle=" + eventtitle + ", eventcontent=" + eventcontent + "]";
	}
	
	

}
