package demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import utils.FileUtils;

public class Ex06 {
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines("Trader");
		lines.forEach(System.out::println);

		System.out.println("================");
		// line >> name-city
		// using constructor reference
		// List<Trader> traders = convert(lines, Trader::new);

		// Using method reference
//		List<Trader> traders = convert(lines, Trader::new);
//		traders.forEach(System.out::println);
//		Array.newInstance(Object.class, size);
//		Array.newInstance(null, 0)
	}

	private static <T> List<T> convert(List<String> lines, Function<String, T> function) {
		List<T> rs = new ArrayList<>();
		for (String line : lines) {
			T t = function.apply(line);
			if (t != null) {
				rs.add(t);
			}
		}
		return rs;
	}
}