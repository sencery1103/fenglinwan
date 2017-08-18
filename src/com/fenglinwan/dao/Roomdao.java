package com.fenglinwan.dao;

import java.util.List;

import com.fenglinwan.entity.Room;


public interface Roomdao {
	public List <Room> SelectRoom(String id) ;
	
	public  int ie(String sql,Object...params);
	
	public List<Room> SelectAll() ;
}
