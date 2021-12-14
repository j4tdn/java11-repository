package demo;

import static utils.SqlUtils.print;

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
		
		breakLine("itemByIgAtIdx1");
		
		ItemGroup itemGroup = itemGroups.get(1);
		List<Item> itemByIgAtIdx1 = itemGroup.getItems();
		print(itemByIgAtIdx1);
		
		breakLine("items");
		
		List<Item> items = itemService.getAll();
		print(items);
	}
}