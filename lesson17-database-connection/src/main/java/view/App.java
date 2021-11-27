package view;

import java.time.LocalDate;
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
	private static ItemGroup newGroup;
	private static String email;
	private static String password;
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	private static LocalDate orderDate;
	private static EmployeeService employeeService;

	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		employeeService = new EmployeeServiceImpl();
		
		igId = 5;
		igName = "Áo";
		orderDate = LocalDate.of(2020, 12, 18);
		email = "truongdat1408@gmail.com";
		password = "123";
		
		newGroup = new ItemGroup(999, "Saved Item Group 999");
	}

	public static void main(String[] args) {
//		List<ItemGroup> groups = itemGroupService.getAll();
//		print(groups);
//		
//		System.out.println("\n ==\\\\\\== \n");
//		ItemGroup group = itemGroupService.get(igId);
//		
//		print("group", group);
//		
//		System.out.println("\n ==\\\\\\== \n");
//		
//		boolean isUpdate = itemGroupService.update(newGroup);
//		print("isUpdate", isUpdate);
//		
//		System.out.println("\n ==\\\\\\== \n");
//		
//		boolean isUpdateOrSave = itemGroupService.saveOrUpdate(newGroup);
//		print("isUpdateOrSave", isUpdateOrSave);
//		
//		System.out.println("\n ==\\\\\\== \n");
//		
//		List<ItemGroup> groupsByName = itemGroupService.get(igName);
//		print(groupsByName);
		
		System.out.println("\n ==\\\\\\== \n");
		
		List<Item> itemsByIgName = itemService.get(igName);
		print(itemsByIgName);
		
		System.out.println("\n ==\\\\\\== \n");
		
		List<Item> itemsByOrderDate = itemService.get(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n ==\\\\\\== \n");
		
		List<ItemGroupDto> itemsByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemsByIgId);
		
//		System.out.println("\n ==\\\\\\== \n");
//		
//		Employee regEmp = employeeService.signup(email, password);
//		print("regEmp", regEmp);
		
		System.out.println("\n ==\\\\\\== \n");
		
		Employee signingUpAccount = employeeService.signin(email, password);
		print("regEmp", signingUpAccount);
	}
}
