package com.fenglinwan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fenglinwan.dao.Roomdao;
import com.fenglinwan.entity.Room;
import com.fenglinwan.uitl.DButil;

public class Roomdaoimpl implements Roomdao{
	Connection conn=DButil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
	@Override
	public List<Room> SelectRoom(String id) {
		// TODO Auto-generated method stub
		String SQL= "SELECT r.*,rt.typename,rt.roomprice\r\n" + 
				"  FROM room r,roomtype rt\r\n" + 
				" WHERE r.roomtype=rt.type AND r.hot_id='"+id+"'";
		List <Room> list=new ArrayList<Room>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while(rs.next()) {
				Room ro=new Room();
				ro.setRoomId(rs.getString("ROOMID"));
				ro.setRoomPath(rs.getString("ROOMPATH"));
				ro.setRoomtype(rs.getString("ROOMTYPE"));
				ro.setMoney(rs.getString("ROOMPRICE"));
				ro.setRoomName(rs.getString("TYPENAME"));
				ro.setHotelid(rs.getString("hot_id"));
				list.add(ro);
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
	
	
	@Override
	public int ie(String sql, Object... params) {
		// TODO Auto-generated method stub
		int result=0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeAll(rs, pstmt, conn);
		}
		
		return result;
	}
	
	public List<Room> SelectAll() {
		String sql="select * from ROOM";
		List <Room> list=new ArrayList<Room>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Room ro=new Room();
				ro.setRoomId(rs.getString("ROOMID"));
				ro.setRoomPath(rs.getString("ROOMPATH"));
				ro.setRoomtype(rs.getString("ROOMTYPE"));
				ro.setHotelid(rs.getString("hot_id"));
				list.add(ro);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			 DButil.closeAll(rs, pstmt, conn);
		}
		return list;
	}
}
