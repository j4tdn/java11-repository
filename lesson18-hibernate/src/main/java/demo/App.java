package demo;

import static utils.SqlUtils.*;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class App {

	private static ItemGroupService itemGroupService;

	static {
		itemGroupService = new ItemGroupServiceImpl();
	}

	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		print(itemGroups);

		breakLine("itemsByIgAtIdx1");
		ItemGroup itemGroup = itemGroups.get(1);
		List<Item> itemsByIgAtIdx1 = itemGroup.getItems() ;
		System.out.println(itemsByIgAtIdx1);
		
		breakLine("items");
		List<ItemGroup> items = itemGroupService.getAll();
		print(items);
	}

}
