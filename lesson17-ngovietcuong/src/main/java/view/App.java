package view;

import static utils.SqlUtils.print;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupDto;
import persistence.ItemsDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {
	private static LocalDate orderDate;
	private static int year;
	
	private static ItemService itemService;
	private static ItemGroupService itemGroupService;
	
	static {
		itemService = new ItemServiceImpl();
		itemGroupService = new ItemGroupServiceImpl();
		
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		year = 2020;
	}
	
    public static void main(String[] args){
    	System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<ItemDto> itemsByOrderDate = itemService.get(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<ItemGroupDto> itemsByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemsByIgId);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<String> topThreeItem = itemService.getTopThreeItem(year);
		print(topThreeItem);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<ItemsDto> getItems = itemService.getItems();
		print(getItems);
    }
}
