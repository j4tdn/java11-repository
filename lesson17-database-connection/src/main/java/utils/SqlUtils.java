package utils;

import java.util.List;

public class SqlUtils {

	private SqlUtils() {
	}

	public static void close(AutoCloseable... autoCloseables) {
		try {
			for (AutoCloseable closeable : autoCloseables) {
				if (closeable != null) {
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
}