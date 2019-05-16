package com.poet.ordering.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionManager {

	DBInfo dbInfo = DBInfo.instance();

	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName(DBInfo.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.USER, DBInfo.PASS);
		} catch (Exception e) {
			throw e;
		}

		return conn;
	}
	
	
	public static void closeConnection(Statement stmt, ResultSet rs, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}

			conn = null;
		}
	}

}
