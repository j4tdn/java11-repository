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
	private static int igID;
	private static String igName;
	private static String igNameInjection;
	private static ItemGroup newGroup;
	private static LocalDate orderDate;
	private static String email;
	private static String password;
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	public static EmployeeService employeeService;
	
	static {
		itemService=new ItemServiceImpl();
		itemGroupService=new ItemGroupServiceImpl();
		employeeService = new EmployeeServiceImpl();
		email = "terry@gmail.com";
		password = "test123456";
		 orderDate = LocalDate.of(2020, 12, 18);
		igID=5;
		igName="Áo";
		igNameInjection = "xyz' OR '1=1";
		newGroup=new ItemGroup(991, "Saved Item Group 992");
		
	}
	
	public static void main(String[] args) {
		List<ItemGroup> groups=itemGroupService.getAll();
		print(groups);
		
		
		System.out.println("\n==\\\\==\n");
		ItemGroup group=itemGroupService.get(igID);
		print("group",group);
		
		System.out.println("\n==\\\\==\n");
		boolean isSaved=itemGroupService.saveOrUpdate(newGroup);
		print("isaved",isSaved);
		
		System.out.println("\n==\\\\==\n");
		List<ItemGroup> groupByName = itemGroupService.get(igName);
		print(groupByName);
		
		System.out.println("\n==\\\\==\n");
		List<Item> itemsByIgName=itemService.get(igName);
		print(itemsByIgName);
	
		System.out.println("=========== || ====================");
		List<Item> itemByOrderDate =  itemService.get(orderDate);
		print(itemByOrderDate);
		
		
		System.out.println("=========== || ====================");
		List<ItemGroupDto> getItems =  itemGroupService.getItemsByItemGroupId();
		print(getItems);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee regEmp = employeeService.signup(email, password);
		print("regEmp", regEmp);
	
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee signUpAccount = employeeService.signin(email, password);
		print("signEmp", signUpAccount);
	}
	
	
	
}
