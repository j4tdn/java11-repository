package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DbManager {
	private static Connection connection;
	private static String DRIVER = "DRIVER";
	private static String URL = "URL";
	private static String USERNAME = "USERNAME";
	private static String PASSWORD = "PASSWORD";
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Properties props = DbProvide.getProps();
				
				// 1. Provide driver
				System.out.println(" !! driver : " + Driver.class.getName());
				Class.forName(props.getProperty(DRIVER));

				// 2. Provide database info
			connection = DriverManager.getConnection(props.getProperty(URL), props.getProperty(USERNAME),props.getProperty(PASSWORD));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		return connection;
	}
}
