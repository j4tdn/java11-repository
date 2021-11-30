package view;

import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupDto;
import persistence.ItemsDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.DateUtils;

public class App {
	private static ItemService itemService;
	private static ItemGroupService itemGroupService;
	
	static {
		itemService = new ItemServiceImpl();
		itemGroupService = new ItemGroupServiceImpl();
		
	}
	
	public static void main(String[] args) {
		// Câu 1
		List<ItemDto> items = itemService.getItemSoldByDay(DateUtils.toLocalDate("2020-12-18"));
		items.forEach(System.out::println);
		
		System.out.println("\n==========================================================");
		
		// Câu 2
		List<ItemGroupDto> itemGroups = itemGroupService.getAmountItemGroup();
		itemGroups.forEach(System.out::println);
		
		System.out.println("\n==========================================================");
		
		// Câu 3
		List<String> nameItems = itemService.getItemBestSold(2020);
		nameItems.forEach(System.out::println);
		
		System.out.println("\n==========================================================");
		// Câu 4
		List<ItemsDto> itemGroupss = itemGroupService.getAllItemById();
		itemGroupss.forEach(System.out::println);
	}
}
