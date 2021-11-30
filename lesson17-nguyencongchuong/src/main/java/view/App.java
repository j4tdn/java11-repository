package view;

import static utils.SqlUtils.print;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;


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
	
	public static LocalDate localDate;

	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
	// 	employeeService = new EmployeeServiceImpl();
		
		igId = 5;
		igName = "Áo";
		igNameInjection = "'xyz' OR '1=1'";
		email = "terry@gmail.com";
		password = "test123456";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		newGroup = new ItemGroup(999, "Saved Item Group 159");
	}

	public static void main(String[] args) {
		// Câu 1
		List<ItemGroupDto> getItemGroupDto = itemGroupService.getItemsByItemGroupId(orderDate);
		print(getItemGroupDto);
		
		System.out.println("=================");
		
		// Câu 2
		List<ItemDto> listItemDto = itemService.getItemGroup();
		print(listItemDto);
		
		System.out.println("=================");
		
		// Câu 3
	}
}