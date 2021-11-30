package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static int igId;
	private static String igName;
	private static String igNameInjection;
	private static LocalDate orderDate;
	private static ItemGroup newGroup;
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	static {
		igId = 2;
		igName = "Áo";
		igNameInjection = "xyz' OR '1=1";
		orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		newGroup = new ItemGroup(999, "Saved Item Group 997");
	}
	
    public static void main( String[] args ) {
        List<ItemGroup> groups = itemGroupService.getAll();
        print(groups);
        
        System.out.println("\n ==\\\\\\== \n");
        
        ItemGroup group = itemGroupService.get(igId);
        print("group", group);
        
        boolean isSaved = itemGroupService.update(newGroup);
        print("isSaved: ", isSaved);
        
        System.out.println("\n ==\\\\\\== \n");
        List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
        print(groupsByName);
        
        System.out.println("\n ==\\\\\\== \n");
        List<Item> itemsByIgName = itemService.get(igName);
        print(itemsByIgName);
        
        System.out.println("\n ==\\\\\\== \n");
        List<Item> itemsByOrderDate = itemService.get(orderDate);
        print(itemsByOrderDate);
    }
}
