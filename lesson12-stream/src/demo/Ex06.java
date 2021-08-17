package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import utils.FileUtils;

public class Ex06 {
	public static void main(String[] args) {
		List<String> lines = FileUtils.readLines("Trader.txt");
		
		lines.forEach(System.out::println);
		// lines >> name-city
//		List<Trader> traders = FileUtils.convert(lines, Trader::new);
		List<Trader> traderss = FileUtils.convert(lines, Trader::tranfer);
		
		
		
//		for(String line : lines) {
//			String[] tokens = line.split("-");
//			if(tokens.length == 2) {
//				Trader trader = new Trader(tokens[0], tokens[1]);
//				traders.add(trader);
//			}
//		}
		
		System.out.println("================Traders================");
//		traders.forEach(System.out::println);
		traderss.forEach(System.out::println);
	}
	
}
