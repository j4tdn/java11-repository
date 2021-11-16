package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProvider {

	public static String CONFIG_PATH = "config.properties";

	public static Properties getProps() {
		Properties props = new Properties();

		try {
			props.load(new FileInputStream(new File(CONFIG_PATH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return props;
	}
}
