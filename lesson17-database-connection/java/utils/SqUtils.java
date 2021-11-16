package utils;

import java.util.List;

public class SqUtils {
	public SqUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static <Element> void print(List<Element> elements) {
		for (Element element : elements) {
			System.out.println(element);
		}
	}

	public static <Element> void print(String prefix, Element element) {
		System.out.println(prefix + ">>>" + element);
	}
}
