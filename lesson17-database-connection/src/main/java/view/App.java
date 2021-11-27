package view;

import static utils.SqlUtils.print;

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

public class App {

	private static int igId;
	private static ItemGroup newGroup;
    private static String name;
	private static String igNameInjection;
	private static LocalDate orderDate;
	private static String email;
	private static String password;
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	public static EmployeeService employeeService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		igId = 5;
		name = "Áo";
		email = "quochung@gmail.com";
		password = "123";
		orderDate = LocalDate.of(2020, 12, 18);
		igNameInjection = "'xyz' OR '1=1'";
		newGroup = new ItemGroup(999, "Saved Item Group 123");
		employeeService = new EmployeeServiceImpl();
	}

	public static void main(String[] args) {
		List<ItemGroup> groups = itemGroupService.getAll();
		print(groups);

		System.out.println("\n ============\\\\\\============ \n");
		ItemGroup group = itemGroupService.get(igId);
		print("group", group);
		
		System.out.println("\n ============\\\\\\============ \n");
		
		boolean saveOrUpdate = itemGroupService.saveOrUpdate(newGroup);
		print("saveOrUpdate", saveOrUpdate);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
		print(groupsByName);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<Item> itemByIgName = itemService.get(name);
		print(itemByIgName);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<Item> itemByOrderDate = itemService.get(orderDate);
		print(itemByOrderDate);
		
		System.out.println("\n ============\\\\\\============ \n");
		List<ItemGroupDto> igDto = itemGroupService.getItemsByItemGroupId();
		print(igDto);
		
//		System.out.println("\n ============\\\\\\============ \n");
//		Employee regEmp = employeeService.signup(email, password);
//		print("regEmp", regEmp);
		
		System.out.println("\n ============\\\\\\============ \n");
		Employee signingUpAccount = employeeService.signin(email, password);
		print("signingUpAccount", signingUpAccount);
	}
}
