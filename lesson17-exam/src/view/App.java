package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static int igId;
	private static String igName;
	private static String igNameInjection;
	private static String email;
	private static String password;
	private static LocalDate orderDate;
	private static ItemGroup newGroup;
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;

	static {
		itemService = new ItemServiceImpl();

		
		igId = 5;
		igName = "Áo";
		igNameInjection = "'xyz' OR '1=1'";
		email = "terry@gmail.com";
		password = "test123456";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		newGroup = new ItemGroup(999, "Saved Item Group 159");
	}

	public static void main(String[] args) {
		List<ItemGroup> groups = itemGroupService.getAll();
		print(groups);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		
		List<ItemGroupDto> itemsByIgId = itemGroupService.getItemGroupbyDateDelivery(orderDate);
		print(itemsByIgId);
	}
}
