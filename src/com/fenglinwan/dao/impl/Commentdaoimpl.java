package com.fenglinwan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fenglinwan.dao.Commentdao;
import com.fenglinwan.entity.Comment;
import com.fenglinwan.entity.Hotel;
import com.fenglinwan.uitl.DButil;

public class Commentdaoimpl implements Commentdao{
	Connection conn=DButil.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
	

	@Override
	public List<Comment> SelectAll() {
		// TODO Auto-generated method stub
		String sql="select * from COMMENTARY ";
		
		List <Comment> list=new ArrayList<Comment>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Comment ho=new Comment();
				ho.setOrderId(rs.getString(1));
				ho.setUsername(rs.getString(2));
				ho.setSubtance(rs.getString(3));
				ho.setDate(rs.getString(4));
				list.add(ho);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			 DButil.closeAll(rs, pstmt, conn);
		}
		return list;
	}


	
	@Override
	public void insert(String OrderID, String name, String subtance, String date) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO COMMENTARY VALUES(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, OrderID);
			pstmt.setObject(2, name);
			pstmt.setObject(3, subtance);
			pstmt.setObject(4, date);
			rs=pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DButil.closeAll(rs, pstmt, conn);
		}
	}



}
