package com.fenglinwan.entity;

public class Room {
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomtype=" + roomtype + ", roomPath=" + roomPath + ", money=" + money
				+ ", roomName=" + roomName + ", hotelid=" + hotelid + ", roomed=" + roomed + "]";
	}
	private String roomId;
	private String roomtype;
	private String roomPath;
	private String money;
	private String roomName;
	private String hotelid;
	private boolean roomed=false;
	public boolean getRoomed() {
		return roomed;
	}
	public void setRoomed(boolean roomed) {
		this.roomed = roomed;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getRoomPath() {
		return roomPath;
	}
	public void setRoomPath(String roomPath) {
		this.roomPath = roomPath;
	}
}
