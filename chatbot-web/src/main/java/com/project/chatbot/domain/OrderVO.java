package com.project.chatbot.domain;

public class OrderVO {

	private int orderno;
	private int storeno;
	private String hamburger;
	private String h_ingredient;
	private String h_single;
	private String side;
	private String drink;
	private String price;
	private String payment;
	private String packaging;
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public String getHamburger() {
		return hamburger;
	}
	public void setHamburger(String hamburger) {
		this.hamburger = hamburger;
	}
	public String getH_ingredient() {
		return h_ingredient;
	}
	public void setH_ingredient(String h_ingredient) {
		this.h_ingredient = h_ingredient;
	}
	public String getH_single() {
		return h_single;
	}
	public void setH_single(String h_single) {
		this.h_single = h_single;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	@Override
	public String toString() {
		return "OrderVO [orderno=" + orderno + ", storeno=" + storeno + ", hamburger=" + hamburger + ", h_ingredient="
				+ h_ingredient + ", h_single=" + h_single + ", side=" + side + ", drink=" + drink + ", price=" + price
				+ ", payment=" + payment + ", packaging=" + packaging + "]";
	}
	
	
}
