package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static LocalDate orderDate;
	
	private static ItemService itemService;
	private static final ItemGroupService itemGroupService;
	static {
		itemService = new ItemServiceImpl();
		itemGroupService = new ItemGroupServiceImpl();

		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
	}
	
	public static void main(String[] args) {
		//1. 
		List<ItemDto> itemByOrderDate = itemService.get(orderDate);
		print(itemByOrderDate);
		
		System.out.println("=============///\\\=============");
		
		//2.
		List<ItemGroupDto> itemByGroupIgId = itemGroupService.getItemsByItemGroupId();
		print(itemByGroupIgId);
		
		//3.
	}
}
