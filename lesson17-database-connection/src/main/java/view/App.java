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
import util.SqlUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static int igId ;
	private static String igName;
	private static String igNameInjection;
	private static String email;
	private static String passworld;
	private static ItemGroup newGroup;
	private static LocalDate orderDate;
	
	
	private static ItemService itemService;
	private static ItemGroupService itemGroupService;
	private static EmployeeService employeeService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		employeeService = new EmployeeServiceImpl();
		
		orderDate =  LocalDate.of(2020, 12, 18);
		igId = 5;
		igName = "Áo";
		igNameInjection = "xyz' OR '1=1";
		newGroup = new ItemGroup(999, "Save Item Group 123");
		email = "terry@gmail.com";
		passworld = "text123";
		
	}
	
	public static void main(String[] args) {
//		List<ItemGroup> groups =  itemGroupService.getAll();
//		SqlUtils.print(groups);
		
		System.out.println("=========== || ====================");
		
//		ItemGroup group = itemGroupService.get(igId);
//		SqlUtils.print("group : ", group);
		
		System.out.println("=========== || =====================");
		
//		boolean isSaved = itemGroupService.save(newGroup);
//		SqlUtils.print("isSaved", isSaved);
		
//		boolean saveOrUpdate = itemGroupService.saveOrUpdate(group);
//		SqlUtils.print("saveOrUpdate", saveOrUpdate);
		
//		System.out.println("=========== || ====================");
//		List<ItemGroup> groupsByName =  itemGroupService.get(igName);
//		SqlUtils.print(groupsByName);
		
		System.out.println("=========== || ====================");
//		List<Item> itemByItems =  itemService.get(igName);
//		SqlUtils.print(itemByItems);
		
		System.out.println("=========== || ====================");
//		List<Item> itemByOrderDate =  itemService.get(orderDate);
//		SqlUtils.print(itemByOrderDate);
		
		
		System.out.println("=========== || ====================");
//		List<ItemGroupDto> itemsByItemGroupId = itemGroupService.getItemsByItemGroupId();
//		SqlUtils.print(itemsByItemGroupId);
		
		System.out.println("=========== || ====================");
		Employee regEmp = employeeService.signup(email, passworld);
		SqlUtils.print("regEmp",regEmp);
		
	}
}
