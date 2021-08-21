package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import utils.FileUtils;

public class Ex06 {
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines("E:\\Temp\\JAVA11\\java11-repository\\lesson12-stream\\trader.txt");
		lines.forEach(System.out::println);
		
		System.out.println("====================");
		
		List<Trader> traders = new ArrayList<>();
		// line >> name city
		
		// Long code
		for (String line: lines) {
			String[] tokens = line.split("-");
			if (tokens.length == 2) {
				Trader trader = new Trader(tokens[0], tokens[1]);
				traders.add(trader);
			}
		}
		
		// Long code 
		List<Trader> traders1 = convert(lines, new Function<String, Trader>() {
			@Override
			public Trader apply(String line) {
				Trader trader = null;
				String[] tokens = line.split("-");
				if (tokens.length == 2) {
					trader = new Trader(tokens[0], tokens[1]);
				}
				return trader;
			}
		});
		traders.forEach(System.out::println);
		
		// Short code
		List<Trader> traders2 = convert(lines, line -> new Trader(line));
		List<Trader> traders3 = convert(lines, Trader::new);
		List<Trader> trader4 = convert(lines, Trader::transfer);
		traders.forEach(System.out::println);
	}
	
	private static List<Trader> convert(List<String> lines, Function<String, Trader> function) {
		List<Trader> traders = new ArrayList<>();
		for (String line: lines) {
			Trader trader = function.apply(line);
			if (trader != null) {
				traders.add(trader);
			}
		}
		return traders;
	}
	
	private static <T> List<T> convert1(List<String> lines, Function<String, T> function) {
		List<T> result = new ArrayList<>();
		for (String line: lines) {
			T t = function.apply(line);
			if (t != null) {
				result.add(t);
			}
		}
		return result;
	}
	

}
