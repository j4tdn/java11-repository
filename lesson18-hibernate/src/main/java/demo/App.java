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
	public static void main(String[] args) {
		ItemGroupService itemGroupService = new ItemGroupServiceImpl();
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		System.out.println("============================");
		SqlUtils.print(itemGroups);
		
		System.out.println("=============================");
		ItemService itemService = new ItemServiceImpl();
		List<Item> items = itemService.getAll();
		SqlUtils.print(items);
		
	}
}
