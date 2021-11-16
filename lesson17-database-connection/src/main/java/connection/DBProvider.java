package connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DBProvider {
	private static String CONFIG_PATH = "config.properties";
	public static Properties getProperties() {
		Properties properties = new Properties();
		
		InputStream is;
		try {
			is = new FileInputStream(CONFIG_PATH);
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
}