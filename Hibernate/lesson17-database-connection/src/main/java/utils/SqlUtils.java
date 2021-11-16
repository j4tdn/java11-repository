package utils;

import java.util.List;

import javax.lang.model.element.Element;

public class SqlUtils {
	public SqlUtils() {
		// TODO Auto-generated constructor stub
	}
	public static void close(AutoCloseable... closeables) {
		try {
			for(AutoCloseable closeable: closeables) {
				if(closeable!=null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static <T> void print(List<T> elements) {
		for(T element:elements) {
			System.out.println(element);
		}
	}
	
	public static <T> void print(String prefix, T element) {
		System.out.println(prefix + " >>> " +element);
	}
}
