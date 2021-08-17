package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import utils.FileUtils;

public class Ex06 {
	public static void main(String[] args) {
		
		List<String> lines = FileUtils.readLines("trader.txt");
		lines.forEach(System.out::println);
		
		System.out.println("============================");
		//line >> name -city
		//using constructor reference
		//List <Trader> traders = convert(lines, Trader::new);
		
		//using method reference
		List<Trader> traders = convert(lines, Trader::transfer);
		traders.forEach(System.out::println);
	}
	
	private static <T> List<T> convert(List<String> lines, Function<String, T> function) {
		List<T> result = new ArrayList<>();
		for (String	 line : lines) {
			T t = function.apply(line);
			if(t != null) {
				result.add(t);
			}
		}
		return result;
	}
}
