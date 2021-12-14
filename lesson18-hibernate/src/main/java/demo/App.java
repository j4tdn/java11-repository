package demo;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import util.SqlUtils;

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
		
		SqlUtils.breakLine();
		
		ItemGroup itemsByItemGroup = itemGroups.get(1);
		List<Item> itemss = itemsByItemGroup.getItems();
		SqlUtils.print(itemss);
		
		SqlUtils.breakLine();
		List<Item> items= itemService.getAll();
		SqlUtils.print(items);
		
	}
}
