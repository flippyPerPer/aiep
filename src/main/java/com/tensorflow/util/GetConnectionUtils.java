package com.tensorflow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetConnectionUtils {
	
	private static final String DRIVER_NAEM = "com.mysql.cj.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://localhost:3306/aiep?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	
	private static final String USER_NAME = "root";
	
	private static final String USER_PASSWORD = "wf8060306";
	
	private static Connection connection = null;
	
	public static Connection getoneConnection() {
		
		try {
			Class.forName(DRIVER_NAEM);
			try {
				connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
