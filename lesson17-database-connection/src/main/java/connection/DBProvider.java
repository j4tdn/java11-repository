package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProvider {
	public static String CONFIG_PATH = "config.properties";
	public static Properties getFrops() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(CONFIG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("length: " + props.size());
		return props;
	}
}
