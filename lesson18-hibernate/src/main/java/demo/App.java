package demo;

import java.util.List;
<<<<<<< HEAD

import org.hibernate.SessionFactory;
import static utils.SqlUtils.*;

import persistence.Item;
import persistence.ItemGroup;
import provider.HibernateProvider;
=======

import persistence.Item;
import persistence.ItemGroup;
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
<<<<<<< HEAD
=======

import static utils.SqlUtils.*;
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)

public class App {
	
	private static ItemGroupService itemGroupService;
<<<<<<< HEAD
	private static ItemService itemGroup;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemGroup = new ItemServiceImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		print(itemGroups);
		
		berakLine();
		
		
		List<Item> items = itemGroup.getAll();
=======
	
	private static ItemService itemService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService 	 = new ItemServiceImpl();
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
	}
	public static void main(String[] args) {
			List<ItemGroup> itemGroups = itemGroupService.getAll();
			
			print(itemGroups);
			
			breakLine("itemBy");
			ItemGroup itemGroup = itemGroups.get(1);
			List<Item> itemBy = itemGroup.getItems();
			System.out.println(itemBy);
			
			breakLine("items");
			
			List<Item> items = itemService.getAll();
			print(items);  
			
			
		}
}