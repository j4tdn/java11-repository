package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbProvider {
	
	public static String CONFIG_PATH = "config.properties";
	
	public static Properties getProps() {
		Properties props =  new Properties();
		try {
			props.load(new FileInputStream(new File(CONFIG_PATH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
}
