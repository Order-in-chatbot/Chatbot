package com.project.chatbot.domain;

import org.apache.ibatis.type.Alias;

@Alias("storeVO")
public class StoreVO {
	private int storeno;
	private String storename;
	private String phone;
	private String address;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StoreVO [storeno=" + storeno + ", storename=" + storename + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	

}
