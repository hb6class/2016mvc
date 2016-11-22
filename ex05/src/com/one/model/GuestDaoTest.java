package com.one.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GuestDaoTest {

	@Test
	public void testListAll() {
		GuestDao dao = new GuestDao();
		List<GuestVo> list = dao.listAll();
		assertNotNull(list);
		for(GuestVo bean : list){
			System.out.println(bean);
		}
	}
	
	@Test
	public void testSelectOne(){
		int sabun =1111;
		GuestDao dao = new GuestDao();
		GuestVo bean=dao.selectOne(sabun);
		assertNotNull(bean);
		System.out.println(bean);
	}
	@Test
	public void testDeleteOne(){
		int sabun =7777;
		GuestDao dao = new GuestDao();
		dao.deleteOne(sabun);
	}
}
