package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import utils.FileUtils;

public class Ex06 {
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines("F:\\0_JAVA_DEV\\lesson12-stream\\src\\trader");
		lines.forEach(System.out::println);

		System.out.println("===========================");
		// line >> name - city
		// Using constructor reference
		// List<Trader> traders = convert(lines, Trader::new);

		// Using method reference
		List<Trader> traders = convert(lines, Trader::tranfer);
		traders.forEach(System.out::println);
	}

	private static <T> List<T> convert(List<String> lines, Function<String, T> function) {
		List<T> result = new ArrayList<>();
		for (String line : lines) {
			T t = function.apply(line);
			if (t != null) {
				result.add(t);
			}
		}
		return result;
	}
}