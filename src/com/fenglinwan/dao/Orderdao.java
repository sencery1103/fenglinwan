package com.fenglinwan.dao;

import java.util.List;

import com.fenglinwan.entity.Order;

public interface Orderdao {

	//查询该用户所有订单
	public List <Order> SelectAll(String id);
	
	public int ie(String sql, Object... params);
	
	//查询该酒店所有订单
	public List <Order> Selecthotel(String hotelid);
	
	//查询该房间的所有订单
	public List <Order> SelectRoom(String hotelid,String roomid);
}
