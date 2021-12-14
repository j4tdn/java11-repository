package utils;

import java.sql.PreparedStatement;
import java.util.List;

public class SqlUtils {
	private SqlUtils() {
	}
	
	public static void close(AutoCloseable... closeables) {
		try {
			for (AutoCloseable closeable: closeables) {
				if(closeable != null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <Element> void print(List<Element> elements) {
		for (Element element : elements) {
			System.out.println(element);
		}
	}
	
	public static <Element> void print(String prefix, Element element) {
		System.out.println(prefix + " >>> " + element);
	}

	public static void breakLine(String text) {
		System.out.println("==========" + text + " =======");
	}
	public static int getGeneratedKey(PreparedStatement pst) {
		// TODO Auto-generated method stub
		return 0;
	}
}