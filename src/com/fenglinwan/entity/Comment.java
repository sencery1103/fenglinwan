package com.fenglinwan.entity;

public class Comment {

	private String OrderId;
	private String Username;
	private String subtance;
	private String date;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getSubtance() {
		return subtance;
	}
	public void setSubtance(String subtance) {
		this.subtance = subtance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Comment [OrderId=" + OrderId + ", Username=" + Username + ", subtance=" + subtance + ", date=" + date
				+ "]";
	}
}
