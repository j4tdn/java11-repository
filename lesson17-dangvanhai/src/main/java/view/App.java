package view;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDetailDto;
import persistence.ItemDto;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {
	
	private static ItemService itemService;
	private static ItemGroupService itemGroupService;
	static {
		itemService = new ItemServiceImpl();
		itemGroupService = new ItemGroupServiceImpl();
	}
	public static void main(String[] args) {
		// Ex01: 
		List<ItemDto> listOne = itemService.get(LocalDate.of(2020, 12, 18));
		System.out.println("===== Ex01 ======");
		SqlUtils.print(listOne);
		
		// Ex02: 
		List<ItemGroupDto> listTwo = itemGroupService.getAllemaining();
		System.out.println("===== Ex02 ======");
		SqlUtils.print(listTwo);
		
		// Ex03: 
		List<String> listThree = itemService.getTopHotItemsName(2020);
		System.out.println("===== Ex03 ======");
		SqlUtils.print(listThree);
		
		// Ex04:
		List<ItemDetailDto> listFour = itemService.getAll();
		System.out.println("===== Ex04 ======");
		SqlUtils.print(listFour);
		
	}
}
