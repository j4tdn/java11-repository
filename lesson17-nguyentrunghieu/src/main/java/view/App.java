package view;

import java.util.List;

import dao.ItemDao;
import persistence.Item;
import persistence.ItemGroup;

public class App {

	private static ItemDao itemDao = new ItemDao();

	public static void main(String[] args) {
		System.out.println("===== question 4 =======");
		List<Item> items = itemDao.getItem();
		printf(items);

		System.out.println("====== question 3 ====");
		List<String> itemByBest = itemDao.getItemBuyBest(2020);
		printf(itemByBest);


	}

	public static <T> void printf(List<T> element) {
		for (T t : element) {
			System.out.println(t);
		}
	}

}