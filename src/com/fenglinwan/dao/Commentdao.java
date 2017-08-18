package com.fenglinwan.dao;

import java.util.List;

import com.fenglinwan.entity.Comment;

public interface Commentdao {
	//查询所有的评论
	public List<Comment> SelectAll();
	
	//插入评论
	public void insert(String OrderID,String name,String subtance,String date);

}
