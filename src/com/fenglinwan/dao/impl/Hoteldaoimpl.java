package com.fenglinwan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fenglinwan.dao.Hoteldao;
import com.fenglinwan.entity.Hotel;
import com.fenglinwan.uitl.DButil;

public class Hoteldaoimpl implements Hoteldao{

    Connection conn=DButil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    
	@Override
	public List<Hotel> SelectAll() {
		// TODO Auto-generated method stub
		String SQL= "select t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4,MIN(ty.roomprice) less\r\n" + 
				"from HOTEL t,ROOM ro,ROOMTYPE ty\r\n" + 
				"WHERE t.hot_id=ro.hot_id AND ro.roomtype=ty.type\r\n" + 
				"GROUP BY t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4";
		List <Hotel> list=new ArrayList<Hotel>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while(rs.next()) {
				Hotel ho=new Hotel();
				ho.setCity(rs.getString("CITY"));
				ho.setLocal(rs.getString("LOC"));
				ho.setImgPath(rs.getString("IMGPATH"));
				ho.setName(rs.getString("HOTEL_NAME"));
				ho.setPhone(rs.getString("HOTEL_PHONE"));
				ho.setID(rs.getString("HOT_ID"));
				ho.setLessmoney(rs.getString("less"));
				ho.setRoompath1(rs.getString("ROOMIMGPA1"));
				ho.setRoompath2(rs.getString("ROOMIMGPA2"));
				ho.setRoompath3(rs.getString("ROOMIMGPA3"));
				ho.setRoompath4(rs.getString("ROOMIMGPA4"));
				ho.setRoomcount(rs.getString("ROOMCOUNT"));
				list.add(ho);
			}
		return list;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			 DButil.closeAll(rs, pstmt, conn);
		}
	}
	
	//根据城市和日期查询所有信息
	@Override
	public List<Hotel> SelectCity(String city) {
		// TODO Auto-generated method stub
		String SQL=
				"select t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4,MIN(ty.roomprice) less\r\n" + 
				"from HOTEL t,ROOM ro,ROOMTYPE ty\r\n" + 
				"WHERE t.hot_id=ro.hot_id AND ro.roomtype=ty.type AND city='"+city+"'\r\n" + 
				"GROUP BY t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4";
				List <Hotel> list=new ArrayList<Hotel>();
				try {
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(SQL);
					while(rs.next()) {
						Hotel ho=new Hotel();
						ho.setCity(rs.getString("CITY"));
						ho.setLocal(rs.getString("LOC"));
						ho.setImgPath(rs.getString("IMGPATH"));
						ho.setName(rs.getString("HOTEL_NAME"));
						ho.setPhone(rs.getString("HOTEL_PHONE"));
						ho.setID(rs.getString("HOT_ID"));
						ho.setLessmoney(rs.getString("less"));
						ho.setRoompath1(rs.getString("ROOMIMGPA1"));
						ho.setRoompath2(rs.getString("ROOMIMGPA2"));
						ho.setRoompath3(rs.getString("ROOMIMGPA3"));
						ho.setRoompath4(rs.getString("ROOMIMGPA4"));
						ho.setRoomcount(rs.getString("ROOMCOUNT"));
						list.add(ho);
					}
				return list;	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}finally {
					 DButil.closeAll(rs, pstmt, conn);
				}
	}

	//根据酒店ID查询所有信息
	@Override
	public List<Hotel> SelectID(String ID) {
		// TODO Auto-generated method stub
		String SQL="select t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4,MIN(ty.roomprice) less\r\n" + 
				"from HOTEL t,ROOM ro,ROOMTYPE ty\r\n" + 
				"WHERE t.hot_id=ro.hot_id AND ro.roomtype=ty.type AND t.hot_id='"+ID+"'\r\n" + 
				"GROUP BY t.hot_id,t.loc,t.city,t.hotel_name,t.hotel_phone,t.imgpath,t.roomcount,t.ROOMIMGPA1,t.ROOMIMGPA2,t.ROOMIMGPA3,t.ROOMIMGPA4";
		List <Hotel> list=new ArrayList<Hotel>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while(rs.next()) {
				Hotel ho=new Hotel();
				ho.setCity(rs.getString("CITY"));
				ho.setLocal(rs.getString("LOC"));
				ho.setImgPath(rs.getString("IMGPATH"));
				ho.setName(rs.getString("HOTEL_NAME"));
				ho.setPhone(rs.getString("HOTEL_PHONE"));
				ho.setID(rs.getString("HOT_ID"));
				ho.setLessmoney(rs.getString("less"));
				ho.setRoompath1(rs.getString("ROOMIMGPA1"));
				ho.setRoompath2(rs.getString("ROOMIMGPA2"));
				ho.setRoompath3(rs.getString("ROOMIMGPA3"));
				ho.setRoompath4(rs.getString("ROOMIMGPA4"));
				ho.setRoomcount(rs.getString("ROOMCOUNT"));
				list.add(ho);
			}
		return list;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			 DButil.closeAll(rs, pstmt, conn);
		}
	}

}
