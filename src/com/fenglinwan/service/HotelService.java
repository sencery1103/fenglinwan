package com.fenglinwan.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fenglinwan.dao.Hoteldao;
import com.fenglinwan.dao.Orderdao;
import com.fenglinwan.dao.impl.Hoteldaoimpl;
import com.fenglinwan.dao.impl.Orderdaoimpl;
import com.fenglinwan.entity.Hotel;
import com.fenglinwan.entity.Order;


public class HotelService {
	
	private Hoteldao hd=new Hoteldaoimpl();
	List <Hotel> list=new ArrayList<Hotel>();
	
	public List<Hotel> SelectAll(){
		list=hd.SelectAll();
		return list;
	}
	
	public List<Hotel> Select(String city, String date) {
		list=hd.SelectCity(city);
		Orderdao od=new Orderdaoimpl();
		Iterator it=list.iterator();
		List <Hotel> listhotel=new ArrayList<Hotel>();
		while(it.hasNext()){
			int i=0;
			Hotel ho=(Hotel)it.next();
			List <Order>orderlist=od.Selecthotel(ho.getID());
			Iterator its=orderlist.iterator();
			while(its.hasNext()) {
				Order or=(Order)its.next();
				if(or.getOrderroomdate().equals(date)) {
					i++;
				}
			}
			if(i<Integer.parseInt(ho.getRoomcount())) {
				listhotel.add(ho);
			}
		}
		return listhotel;

	}

	public List<Hotel> Select(String ID){
		list=hd.SelectID(ID);
		return list;
	}

}
