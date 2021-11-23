package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static int igID;
	private static String igName;
	private static LocalDate orderDate;
	private static ItemGroupService itemgroupService;
	private static ItemService itemService;
	private static ItemGroup newGroup;
	
	static {
		itemgroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		
		igID=2;
		igName="Áo";
		orderDate = LocalDate.of(2020, Month.DECEMBER,18);
		newGroup = new ItemGroup(123, "saved item group 153");
	}

	public static void main(String[] args) {
		List<ItemGroup> items = itemgroupService.getAll();
		print(items);
		
		System.out.println("\n ============\\\\\\============ \n");
		ItemGroup group = itemgroupService.get(igID);
		
		print("group",group);
		
//		boolean isSaved = itemgroupService.save(newGroup);
//		print("isSave",isSaved);
		
		System.out.println("\n ============\\\\\\============ \n");
		boolean isSaveOrUpdate = itemgroupService.saveOrUpdate(newGroup);
		print("isSaveOrUpdate",isSaveOrUpdate);
		
		
		System.out.println("\n ============\\\\\\============ \n");
		List<ItemGroup> groupsByName = itemgroupService.get(igName);
		print(groupsByName);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<Item> itemsByIgName = itemService.get(igName);
		print(itemsByIgName);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<Item> itemsByOrderDate= itemService.get(orderDate);
		print(itemsByOrderDate);
		
	}
}
