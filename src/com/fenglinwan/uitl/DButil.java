package com.fenglinwan.uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 数据库工具类
 * */
public class DButil {
	private static final String LIANJIE="jdbc:oracle:thin:@10.25.209.33:1521:orcl";
	private static final String USERNAME="fox";
	private static final String PASSWORD="123456";
	private static Connection conn;
	
	//获取数据库连接
	public static  Connection getConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());  
			conn=DriverManager.getConnection(LIANJIE,USERNAME,PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭所有资源
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(rs!=null)
                rs.close();
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
