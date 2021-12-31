package demo;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
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
		
		System.out.println("=============================");
		List<Item> items = itemService.getAll();
		print(items);
		
		System.out.println("===============================");
		ItemGroup itemGroup = itemGroups.get(2);
		List<Item> itemByIgs = itemGroup.getItems();
		print(itemByIgs);
		
		System.out.println("===============================");
		Item item = itemService.getItem(2);
		print("item: ", item);
		
		System.out.println("===============================");
		List<ItemGroupDto> itemByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemByIgId);
	}
}
