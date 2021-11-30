package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DBManager {
	private static Connection connection;
	private static String URL = "URL";
	private static String DRIVER = "DRIVER";
	private static String USERNAME = "USERNAME";
	private static String PASSWORD = "PASSWORD";
	
	public static Connection getConnection() {
		if (connection == null) {
			Properties props = DBProvider.getFrops();
			try {
				// 1. Provide driver
				Class.forName(props.getProperty(DRIVER));
				System.out.println("driver : " + Driver.class.getName());
				// 2. Provide database info
				connection = DriverManager.getConnection(
						props.getProperty(URL),
						props.getProperty(USERNAME),
						props.getProperty(PASSWORD));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return connection;
	}
}
