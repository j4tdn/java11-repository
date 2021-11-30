package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.Item;
import persistence.ItemDto;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
//	private static int igID;
	private static ItemGroupService itemgroupService;
	private static ItemService itemService;
//	private static ItemGroup newGroup;
//	private static String igName;
	private static LocalDate orderDate;

	private static String yearSellest;
//	private static String password;
//	
	static {

		itemgroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		yearSellest = "2020";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);

	}

	public static void main(String[] args) {

		System.out.println("\n ========== cau 1 ==\\\\\\============ \n");
		List<ItemDto> itemsByOrderDate = itemService.getItemsByDate(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n =========cau 2===\\\\\\============ \n");
		List<ItemGroupDto> Igtems = itemgroupService.getItems();
		print(Igtems);
		
		System.out.println("\n ========== cau 3 ==\\\\\\============ \n");
		List<Item> itemsBestSeller = itemService.getItemsBestSeller(yearSellest);
		print(itemsBestSeller);
		
		System.out.println("\n ========== cau 4 ==\\\\\\============ \n");
		List<Item> itemsAll = itemService.getAll();
		print(itemsAll);
		
	}
}