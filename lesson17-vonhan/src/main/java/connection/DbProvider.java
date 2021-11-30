package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProvider {
	public static String CONFIG_PATH = "config.properties";
	
	public static Properties getPros() {
		Properties properties = new Properties();
		
		try {
			
			properties.load(new FileInputStream(new File(CONFIG_PATH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}
}
