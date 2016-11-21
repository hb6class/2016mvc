package com.mvc2.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mvc2.util.ConnTmlp;

public class SqlTemplate {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SqlTemplate() {
	}
	
	public void executeUpdate(String sql,Object[] obj){
		try {
			pstmt=ConnTmlp.getConnection().prepareStatement(sql);
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
	
	public List executeList(String sql, RowMapper mapper){
		return executeList(sql, null, mapper);
	}
	public List executeList(String sql, Object[] obj, RowMapper mapper){
		try {
			pstmt = ConnTmlp.getConnection().prepareStatement(sql);
			if(obj!=null){
				for(int i=0; i<obj.length; i++){
					pstmt.setObject(i+1, obj[i]);
				}
			}
			rs = pstmt.executeQuery();
			return mapper.rowMapper(rs);
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
	
	public Object executeOne(String sql, Object[] obj, RowMapper mapper){
		return executeList(sql,obj,mapper).get(0);
	}
}
