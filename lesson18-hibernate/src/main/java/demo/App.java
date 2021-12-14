package demo;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		SqlUtils.print(itemGroups);
		
		SqlUtils.breakLine("itemsByIgAtIdx1");
		
		ItemGroup itemGroup = itemGroups.get(1);
		List<Item> itemsByIgAtIdx1 = itemGroup.getItems();
		SqlUtils.print(itemsByIgAtIdx1);
		
		SqlUtils.breakLine("items");
		List<Item> items = itemService.getAll();
		SqlUtils.print(items);
	}
}
