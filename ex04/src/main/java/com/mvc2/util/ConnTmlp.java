package com.mvc2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTmlp {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String password = "tiger";
	private static Connection conn;

	public static Connection getConnection(){
		try {
			Class.forName(driver);
			if(conn==null || conn.isClosed())return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {		
		}
		return conn;
	}
}









