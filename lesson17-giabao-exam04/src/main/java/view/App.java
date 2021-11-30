package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import dto.DetailsItems;
import dto.ItemWithDate;
import dto.RemainingItem;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static LocalDate orderDate;
	private static int year;
	private static ItemService itemService;
	private static ItemGroupService itemGroupService;

	static {
		itemService = new ItemServiceImpl();
		itemGroupService= new ItemGroupServiceImpl();
		orderDate = LocalDate.of(2020, Month.DECEMBER,18);
		year=2020;
	}

	
	public static void main(String[] args) {
		System.out.println("\n ============Ex01============ \n");
		List<ItemWithDate> itemsByOrderDate= itemService.getItemWithDate(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n ============Ex02============ \n");
		List<RemainingItem> listRemainingItems = itemService.getRemainingItems();
		print(listRemainingItems);
		
		System.out.println("\n ============Ex03============ \n");
		List<String> top3SaleItems = itemService.getTop3SaleItems(year);
		print(top3SaleItems);
		
		
		System.out.println("\n ============Ex03============ \n");
		List<DetailsItems> itemsByGroupItems = itemGroupService.getItemsByGroupItem();
		print(top3SaleItems);
		
		
	}
}
