package manipulation;

import static Utils.FileUtils.*;

import java.io.File;
import java.util.Properties;

public class Ex04 {
	private static final String path = "data" + File.separator + "config.properties";

	public static void main(String[] args) {
		File file = new File(path);
		Properties props =  getProperties(file);
		
		System.out.println("dbname:  " + props.getProperty("dbname"));
		System.out.println("dbtype: " + props.getProperty("dbtype123"));
	}
}
