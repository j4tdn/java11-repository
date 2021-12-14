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
	private static ItemGroupService itemGroupService;
	private static ItemGroup newGroup;
	private static ItemService itemService;
	private static EmployeeService employeeService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		employeeService = new EmployeeServiceImpl();
		email = "susan@gmail.com";
		password = "1234";
		igId = 2;
		igName = "Áo";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		igNameInjection = "xyz' OR '1=1";
		newGroup = new ItemGroup(9999, "Saved Item Group 123");
	}
	
	public static void main(String[] args) {
		List<ItemGroup> groups = itemGroupService.getAll();
		print(groups);
		System.out.println("\n == \\\\\\ == \n");
		ItemGroup group = itemGroupService.get(igId);
		print("group", group);
		
		System.out.println("\n == \\\\\\ == \n");
		boolean isSaved = itemGroupService.saveOrUpdate(newGroup);
		print("isSavae", isSaved);
		
		System.out.println("\n == \\\\\\ == \n");
		List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
		print(groupsByName);
		
		System.out.println("\n == \\\\\\ == \n");
		List<Item> itemsByIgName = itemService.get(igName);
		print(itemsByIgName);
		
		System.out.println("\n == \\\\\\ == \n");
		List<Item> itemsByOrderDate = itemService.get(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n == \\\\\\ == \n");
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
