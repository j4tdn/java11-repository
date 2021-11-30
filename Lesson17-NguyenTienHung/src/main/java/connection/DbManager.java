package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManager {
	
	private static Connection connection;
	private static String DRIVER = "DRIVER";
	private static String URL = "URL";
	private static String USERNAME = "USERNAME";
	private static String PASSWORD = "PASSWORD";
	
	public static Connection getConnection() {
		if (connection == null) {
			Properties props = DbProvider.getProps();
			
			try {
				// 1. Provide driver
				Class.forName(props.getProperty(DRIVER));
				
				// 2. Provide database info
				connection = DriverManager.getConnection(
						props.getProperty(URL), 
						props.getProperty(USERNAME), 
						props.getProperty(PASSWORD)
				);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
