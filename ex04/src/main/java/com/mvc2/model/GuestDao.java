package com.mvc2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mvc2.core.RowMapper;
import com.mvc2.core.SqlTemplate;

public class GuestDao {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public GuestDao() {	
	}
	
	class InnerCl implements RowMapper{
		
		@Override
		public List rowMapper(ResultSet rs) throws SQLException {
			List<GuestVo> list = new ArrayList<GuestVo>();
			while(rs.next()){
				list.add(new GuestVo(rs.getInt("sabun"),rs.getString("name")
						, rs.getDate("nalja"), rs.getInt("pay")));
			}
			return list;
		}
	}
	
	public List<GuestVo> selectAll() {
		String sql = "select * from guest";
		return new SqlTemplate().executeList(sql, new InnerCl());
	}


	public GuestVo selectOne(int sabun) {
		String sql ="select * from guest where sabun=?";
		Object[] obj = {sabun};
		return (GuestVo)(new SqlTemplate().executeOne(sql,obj, new InnerCl()));
	}
	
	public void insertOne(GuestVo vo) {
		
		new SqlTemplate().executeUpdate("insert into guest values (?,?,sysdate,?)"
				,new Object[]{vo.getSabun(),vo.getName(),vo.getPay()});
	}
	
	public void updateOne(GuestVo vo) {
		String sql = "update guest set name=?,pay=? where sabun=?";
		Object[] obj = {vo.getName(),vo.getPay(),vo.getSabun()};
		new SqlTemplate().executeUpdate(sql, obj);
		
	}
	
	public void deleteOne(int sabun){
		new SqlTemplate().executeUpdate("delete from guest where sabun=?"
				, new Object[]{sabun});
	}
	
}












