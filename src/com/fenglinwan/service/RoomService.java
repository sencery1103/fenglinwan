package com.fenglinwan.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fenglinwan.dao.Orderdao;
import com.fenglinwan.dao.Roomdao;
import com.fenglinwan.dao.impl.Orderdaoimpl;
import com.fenglinwan.dao.impl.Roomdaoimpl;
import com.fenglinwan.entity.Order;
import com.fenglinwan.entity.Room;

public class RoomService {
	private Roomdao hd=new Roomdaoimpl();
	List <Room> list=new ArrayList<Room>();
	
	public List<Room> SelectRoom(String id){
		list=hd.SelectRoom(id);
		return list;
	}
	
	public  int ie(String sql,Object...params){
		
		int i=hd.ie(sql, params);
		return i;
	}
	
	public List<Room> getRoom(String hotelid,String date) {
		List<Room>list=new ArrayList<Room>();
		List<Room>listselect=new ArrayList<Room>();
		List<Order>orderlist=new ArrayList<Order>();
		list=hd.SelectRoom(hotelid);
		Orderdao od=new Orderdaoimpl();
		orderlist=od.Selecthotel(hotelid);
		
		Iterator its=list.iterator();
		while(its.hasNext()) {
			Room ro=(Room)its.next();
			
			Iterator it=orderlist.iterator();
			while(it.hasNext()) {
				Order or=(Order)it.next();
				if(ro.getRoomId().equals(or.getRoomid())&&date.equals(or.getOrderroomdate())) {
					ro.setRoomed(true);
				}
			}
			listselect.add(ro);
		}
		return listselect;
	}
	
	public List<Room> SelectAll() {
		list=hd.SelectAll();
		return list;
	}
}
