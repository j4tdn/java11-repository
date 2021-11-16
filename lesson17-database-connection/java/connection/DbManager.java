package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManager {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			Properties props = DbProvider.getProps();
			try {
				// 1.Provider driver - class in
				Class.forName(props.getProperty("DRIVER"));

				// 2.Provide database info
				connection = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USERNAME"),
						props.getProperty("PASSWORD"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}
