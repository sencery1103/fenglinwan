package com.fenglinwan.entity;

public class Hotel {
	private String name;
	private String local;
	private String imgPath;
	private String phone;
	private String city;
	private String ID;
	private String lessmoney;
	private String roompath1;
	private String roompath2;
	private String roompath3;
	private String roompath4;
	private String roomcount;
	public String getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(String roomcount) {
		this.roomcount = roomcount;
	}
	public String getRoompath1() {
		return roompath1;
	}
	public void setRoompath1(String roompath1) {
		this.roompath1 = roompath1;
	}
	public String getRoompath2() {
		return roompath2;
	}
	public void setRoompath2(String roompath2) {
		this.roompath2 = roompath2;
	}
	public String getRoompath3() {
		return roompath3;
	}
	public void setRoompath3(String roompath3) {
		this.roompath3 = roompath3;
	}
	public String getRoompath4() {
		return roompath4;
	}
	public void setRoompath4(String roompath4) {
		this.roompath4 = roompath4;
	}
	public String getLessmoney() {
		return lessmoney;
	}
	public void setLessmoney(String lessmoney) {
		this.lessmoney = lessmoney;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", local=" + local + ", imgPath=" + imgPath + ", phone=" + phone + ", city="
				+ city + ", ID=" + ID + ", lessmoney=" + lessmoney + "]";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
