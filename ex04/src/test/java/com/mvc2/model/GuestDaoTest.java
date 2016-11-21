package com.mvc2.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.Test;

public class GuestDaoTest {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String password = "tiger";

	@Test
	public void testCRUD() {
		GuestDao dao = new GuestDao();
		GuestVo vo = new GuestVo(9999, "test", null, 9000);
		dao.insertOne(vo);
		dao = new GuestDao();
		List list = dao.selectAll();
		assertNotNull(list);
		dao = new GuestDao();
		GuestVo bean = dao.selectOne(9999);
		assertEquals(vo, bean);
		dao = new GuestDao();
		vo = new GuestVo(9999, "test2", null, 9900);
		dao.updateOne(vo);
		assertEquals(vo, new GuestDao().selectOne(9999));
		dao = new GuestDao();
		dao.deleteOne(9999);
		assertNull(new GuestDao().selectOne(9999));
	}
}








