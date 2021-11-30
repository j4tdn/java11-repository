package View;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupAmount;
import service.ItemGroupService;

public class App {

	private static ItemGroupService itemGroupService;

	static {
		itemGroupService = new ItemGroupService();
	}

	public static void main(String[] args) {
		System.out.println("Bai 1");
		LocalDate localDate = LocalDate.of(2019, 11, 23);
		Date date = Date.valueOf(localDate);

		List<ItemGroup> list = itemGroupService.itemGroups(date);
		list.forEach(System.out::println);
		System.out.println("------------------------------------");
		
		
		System.out.println("Bai 2");
		List<ItemGroupAmount> Statistical = itemGroupService.ItemGroupAmount();
		Statistical.forEach(System.out::println);
		System.out.println("------------------------------------");
	}
}