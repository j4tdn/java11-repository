package utils;

public class SqlUtils {
	public SqlUtils() {
	}
	
	public static void close(AutoCloseable ...closeables) {
		try {
			for(AutoCloseable closeable: closeables) {
				if (closeable != null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
