package utils;

import java.util.List;

public class SqlUtils {

	private SqlUtils() {
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static <E> void print(List<E> elements) {
		elements.forEach(System.out::println);
	}

	public static <E> void print(String prefix, E e) {
		System.out.println(prefix + ">>>" + e);
	}
}
