package com.mvc2.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDao {

	private String url;
	private String user;
	private String password;
	private String driver;

	public GuestDao(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<GuestVo> selectAll(){
		ArrayList<GuestVo> list = new ArrayList<GuestVo>();
		
		return list;
	}
	
	public void insertOne(GuestVo vo){
		
	}
	
	public GuestVo selectOne(int sabun){
		GuestVo vo = null;
		
		return vo;
	}
	
	public void updateOne(GuestVo vo){
		
	}
	
	public void deleteOne(int sabun){
		
	}
}















