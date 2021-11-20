package utils;

import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

public class SqlUtils {
public static void close(AutoCloseable...autoCloseables) {
	try {
		for(AutoCloseable a:autoCloseables ) {
			a.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public static<Element> void print(Element... elements) {
	for(Element element:elements) {
		System.out.println(element);
	}
}

public static <Element> void print(String prefix,Element element) {
	System.out.println(prefix+ " >>> "+element);
}

}
