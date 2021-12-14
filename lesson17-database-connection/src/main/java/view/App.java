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
	private static EmployeeService employeeService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		employeeService = new EmployeeServiceImpl();
		
		igId = 2;
		igName = "Áo";
		igNameInjection = "xyz' OR '1=1";
		email = "susan@gmail.com";
		password = "test123";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		newGroup = new ItemGroup(999, "Saved Item Group 999");
	}
	
	public static void main( String[] args ){
        List<ItemGroup> groups = itemGroupService.getAll();
        print(groups);
        
        System.out.println("\n ==\\\\\\== \n");
       
        ItemGroup group = itemGroupService.get(igId);
        print("group", group);
        
        System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		 
		boolean saveOrUpdate = itemGroupService.saveOrUpdate(newGroup);
		print("saveOrUpdate", saveOrUpdate);
		
		System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
		print(groupsByName);
		
		System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		List<Item> itemByIgName = itemService.get(igName);
		print(itemByIgName);
		
		System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		List<Item> itemByOrderDate = itemService.get(orderDate);
		print(itemByOrderDate);
		
		System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		List<ItemGroupDto> itemByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemByIgId);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee regEmp = employeeService.signup(email, password);
		print("regEmp", regEmp);
		
		System.out.println("\n ==========\\\\\\\\\\\\\\========== \n");
		Employee signingUpAccount = employeeService.signin(email, password);
		print("signingUpAccount", signingUpAccount);
    }
}
