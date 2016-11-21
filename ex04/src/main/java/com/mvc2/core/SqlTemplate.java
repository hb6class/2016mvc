package com.mvc2.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc2.model.GuestVo;

public abstract class SqlTemplate {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String password = "tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SqlTemplate() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {		
		}
	}
	
	public void executeUpdate(String sql,Object[] obj){
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<obj.length; i++){
				pstmt.setObject(i+1, obj[i]);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List executeList(String sql){
		return executeList(sql, null);
	}
	public List executeList(String sql, Object[] obj){
		try {
			pstmt = conn.prepareStatement(sql);
			if(obj!=null){
				for(int i=0; i<obj.length; i++){
					pstmt.setObject(i+1, obj[i]);
				}
			}
			rs = pstmt.executeQuery();
			return rowMapper(rs);
		} catch (SQLException e) {
		} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
				}
		}
		return null;
	}
	
	public Object executeOne(String sql, Object[] obj){
		return executeList(sql, obj).get(0);
	}

	public abstract List rowMapper(ResultSet rs) throws SQLException;
	
}
