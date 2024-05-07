package com.pms.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtility {

	private static Properties dbProperties;
	
	static {
		dbProperties = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader("src/main/resources/application.properties");
			dbProperties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
//			throw e;
		} catch (IOException e) {
			e.printStackTrace();
//			throw e;
		}finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
//					throw e;
				}
		}
	}
	
	private static String getDbUrl() {
		return dbProperties.getProperty("spring.datasource.url");	
	}
	
	private static String getDbDriver() {
		return dbProperties.getProperty("spring.datasource.driver-class-name");
	}
	
	private static String getDbUserName() {
		return dbProperties.getProperty("spring.datasource.username");
	}
	
	private static String getDbPassword() {
		return dbProperties.getProperty("spring.datasource.password");
	}
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException, Exception {
		Connection conn = null;
		try {
			
			Class.forName(DbUtility.getDbDriver());	
			conn = DriverManager.getConnection(
					 getDbUrl(), 
					 getDbUserName(), 
					 getDbPassword()
					);		
			return conn;
			
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}

