package demo;


import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		print(itemGroups);
		
		breakLine("itemsByIndex");
		
		System.out.println(itemGroups.get(1).getItems());

		breakLine("items");
		
		List<Item> items = itemService.getAll();
		print(items);
	}
}
