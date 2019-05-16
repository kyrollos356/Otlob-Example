package com.poet.ordering.system.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DBInfo {
	static private DBInfo _instance = null;
	static public String JDBC_DRIVER = null;
	static public String DB_URL = null;
	static public String USER = null;
	static public String PASS = null;

	protected DBInfo() {
		try {
			InputStream file = new FileInputStream(new File("D:\\OrderiingSystem\\db.properties"));
			Properties props = new Properties();
			props.load(file);
			JDBC_DRIVER = props.getProperty("JDBC_DRIVER");
			DB_URL = props.getProperty("DB_URL");
			USER = props.getProperty("USER");
			PASS = props.getProperty("PASS");
		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}

	static public DBInfo instance() {
		if (_instance == null) {
			_instance = new DBInfo();
		}
		return _instance;
	}
}
