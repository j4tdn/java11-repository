package ex05;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		Map<Buy, Money> spend = new HashMap<>();
		spend.put(new Buy(15, 7, 8, 4), new Money(50, 150, 300, 80));
		spend.put(new Buy(22, 22, 6, 7), new Money(30, 20, 80, 110));
		spend.put(new Buy(15, 22, 6, 4), new Money(100, 150, 200, 70));
		spend.put(new Buy(19, 23, 4, 43), new Money(20, 90, 80, 60));

		System.out.println("===== Total Over 500 =====");
		Map<Buy, Money> totalOver = totalOver(spend, 500);
		printf(totalOver);
		
		System.out.println("===== Sort Ascending Buy =====");
		Map<Buy, Money> sortAscBuy = sortAscBuy(spend);
		printf(sortAscBuy);
		
		System.out.println("===== Sort Descending Money =====");
		Map<Buy, Money> sortDesMoney = sortDesMoney(spend);
		printf(sortDesMoney);
	}

	public static void printf(Map<Buy, Money> map) {
		Set<Entry<Buy, Money>> entrys = map.entrySet();
		for (Entry<Buy, Money> entry : entrys) {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			System.out.println();
		}
	}

	public static int totalPrice(Money money) {
		int total = 0;
		
		total = money.getPriceFish() + money.getPriceFruit() 
			+ money.getPriceMeat() + money.getPriceVegetable();
		
		return total;
	}
	
	public static int totalBuy(Buy buy) {
		int total = 0;
		
		total = buy.getFish() + buy.getFruit() 
			+ buy.getMeat() + buy.getVegetable();
		
		return total;
	}
	
	public static Map<Buy, Money> totalOver(Map<Buy, Money> map, int money) {
		Map<Buy, Money> result = new HashMap<>();
		
		Set<Entry<Buy, Money>> entrys = map.entrySet();
		for (Entry<Buy, Money> entry : entrys) {
			if(totalPrice(entry.getValue()) > money) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	
	private static Map<Buy, Money> sortAscBuy(Map<Buy, Money> map){
		List<Entry<Buy, Money>> sortList = new LinkedList<>(map.entrySet());
		
		Comparator<Entry<Buy, Money>> comp = (o1, o2) ->
				totalBuy(o1.getKey()) - totalBuy(o2.getKey());
				
		sortList.sort(comp);
		
		Map<Buy, Money> sortMap = new LinkedHashMap<>();
		
		for(Entry<Buy, Money> entry:sortList) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		return sortMap;
	}
	
	private static Map<Buy, Money> sortDesMoney(Map<Buy, Money> map){
		List<Entry<Buy, Money>> sortList = new LinkedList<>(map.entrySet());
		
		Comparator<Entry<Buy, Money>> comp = (o1, o2) ->
				totalPrice(o2.getValue()) - totalPrice(o1.getValue());
				
		sortList.sort(comp);
		
		Map<Buy, Money> sortMap = new LinkedHashMap<>();
		
		for(Entry<Buy, Money> entry:sortList) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		return sortMap;
	}
}
