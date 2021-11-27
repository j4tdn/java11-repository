package view;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import connection.DBManager;
import connection.DBProvider;
import persistence.Item;
import persistence.ItemGroup;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {
	private static int igId = 10;
	private static String igName;
	private static String NameInjection;
	private static LocalDate orderDate;
	private static String email;
	private static String password;
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	private static EmployeeService employeeService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		igName = "Áo";
		NameInjection = "xyz' OR '1=1";
		orderDate = LocalDate.of(2020,12,18);
		email = "boywithlove@ulove.uz.cm";
		password = "boywithlove1341";
		employeeService = new EmployeeServiceImpl();
	}
	
	public static void main(String[] args) {
		// Connection
		Connection connection = DBManager.getConnection();
		System.out.println(connection);
		Properties props = DBProvider.getFrops();
		System.out.println(props.get("URL"));
		
		// 
		ItemGroupService service = new ItemGroupServiceImpl();
		List<ItemGroup> groups = service.getAll();
		SqlUtils.print(groups);
		
		//
		SqlUtils.print("get by igId", itemGroupService.get(igId));
		boolean save = itemGroupService.saveOrUpdate(new ItemGroup(10, "Ghét"));
		System.out.println(save);
		
		System.out.println("=================");
		List<ItemGroup> groupByName = itemGroupService.get(igName);
		System.out.println(groupByName);
		
		System.out.println("==============");
		List<Item> items = itemService.get(igName);
		SqlUtils.print(items);
		
		System.out.println("========orderDate======");
		List<Item> itemByOrderDate = itemService.get(orderDate);
		SqlUtils.print(itemByOrderDate);
	
		System.out.println("======== igDto =======");
		SqlUtils.print(itemGroupService.getItemsByItemGroupId());

		System.out.println("======== signup =======");
		System.out.println(employeeService.signUp(email, password));

		System.out.println("======== signin =======");
		System.out.println(employeeService.signIn(email, password));
	}
}
