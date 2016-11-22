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

}
