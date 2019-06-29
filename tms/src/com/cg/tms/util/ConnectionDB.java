package com.cg.tms.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static Connection connection ;

	public static Connection getConnection() {
		try {
			if (null == connection) {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba",
						"system");
				return connection ;
			}
			return connection;
		} catch (SQLException e) {
			System.err.println("Connection Err with databases");
		}
		return null;
	}

}
