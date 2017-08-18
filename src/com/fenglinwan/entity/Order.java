package com.fenglinwan.entity;

public class Order {
	private String orderid;
	private String username;
	private String userid;
	private String usersex;
	private String uesrphone;
	private String hotid;;
	private String hotname;
	private String roomname;
	private String roomid;
	private String money;
	private String roomtype;
	private String orderdate;
	private String orderroomdate;
	private boolean commented=false;
	private String comment;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isCommented() {
		return commented;
	}
	public void setCommented(boolean commented) {
		this.commented = commented;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUesrphone() {
		return uesrphone;
	}
	public void setUesrphone(String uesrphone) {
		this.uesrphone = uesrphone;
	}
	public String getHotid() {
		return hotid;
	}
	public void setHotid(String hotid) {
		this.hotid = hotid;
	}
	public String getHotname() {
		return hotname;
	}
	public void setHotname(String hotname) {
		this.hotname = hotname;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrderroomdate() {
		return orderroomdate;
	}
	public void setOrderroomdate(String orderroomdate) {
		this.orderroomdate = orderroomdate;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", username=" + username + ", userid=" + userid + ", usersex=" + usersex
				+ ", uesrphone=" + uesrphone + ", hotid=" + hotid + ", hotname=" + hotname + ", roomname=" + roomname
				+ ", roomid=" + roomid + ", money=" + money + ", roomtype=" + roomtype + ", orderdate=" + orderdate
				+ ", orderroomdate=" + orderroomdate + "]";
	}
	
}
