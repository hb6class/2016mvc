package com.one.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.sql.RowMapper;
import com.hb.sql.SqlTemplate;

public class GuestDao {
	RowMapper mapper = new RowMapper() {
		@Override
		public List rowMapper(ResultSet rs) throws SQLException {
			List list = new ArrayList<GuestVo>();
			while(rs.next()){
				GuestVo bean = new GuestVo(rs.getInt("sabun")
						,rs.getString("name"),rs.getDate("nalja")
						,rs.getInt("pay"));
				list.add(bean);
			}
			return list;
		}
	};		
	
	public GuestDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<GuestVo> listAll(){
		return new SqlTemplate().executeList("select * from guest", mapper);
	}
	
	public void insertOne(Object[] obj){
		new SqlTemplate().executeUpdate("insert into guest values (?,?,sysdate,?)", obj);
	}
	
	public GuestVo selectOne(int sabun){
		
		return (GuestVo)(new SqlTemplate().executeOne("select * from guest where sabun=?"
				, new Object[]{sabun}, mapper));
	}
	
	public void updateOne(Object[] obj){
		new SqlTemplate().executeUpdate("update guest set name=?,pay=? where sabun=?"
				, obj);
	}
	
	public void deleteOne(int sabun){
		new SqlTemplate().executeUpdate("delete from guest where sabun=?"
				, new Object[]{sabun});
	}
}














