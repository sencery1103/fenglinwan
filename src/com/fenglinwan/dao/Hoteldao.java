package com.fenglinwan.dao;

import java.util.List;

import com.fenglinwan.entity.Hotel;


public interface Hoteldao {
	public List <Hotel> SelectAll();
	
	public List <Hotel> SelectCity(String city);
	
	public List <Hotel> SelectID(String ID);
}
