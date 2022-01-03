package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.Employee;
import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.EmployeeService;
import service.EmployeeServiceImpl;
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
	public static EmployeeService employeeService;

	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		employeeService = new EmployeeServiceImpl();
		
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
		
		ItemGroup group = itemGroupService.get(igId);
		print("group", group);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		
		boolean saveOrUpdate = itemGroupService.saveOrUpdate(newGroup);
		print("saveOrUpdate", saveOrUpdate);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
		print(groupsByName);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<Item> itemsByIgName = itemService.get(igName);
		print(itemsByIgName);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<Item> itemsByOrderDate = itemService.get(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		List<ItemGroupDto> itemsByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemsByIgId);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee regEmp = employeeService.signup(email, password);
		print("regEmp", regEmp);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee signingUpAccount = employeeService.signin(email, password);
		print("signingUpAccount", signingUpAccount);
	}
}