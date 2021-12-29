package demo;


import java.util.List;

import persistence.Item;
import persistence.ItemDetail;
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
		
		
		breakLine("Câu 1");
		System.out.println(itemGroups.get(1).getItems());

		
		breakLine("Câu 2||4");
		List<Item> items = itemService.getAll();
		print(items);
		 
		
		breakLine("Câu 4");
		Item firstItem = items.get(1);
		List<ItemDetail> itemDetails = firstItem.getItemDetails();
		System.out.println("Size: " + itemDetails.size());
		
		breakLine("Câu 3");
		Item item = itemService.getItem(1);
		print("item: ", item);
	}
}
