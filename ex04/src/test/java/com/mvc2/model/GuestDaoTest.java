package com.mvc2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GuestDaoTest {

	@Test
	public void testSelectAll() {
		GuestDao dao = new GuestDao();
		List<GuestVo> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
		for(GuestVo vo:list){
			System.out.println(vo);
		}
	}

}
