package view;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;
import connection.DbManager;
import connection.DbProvider;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import utils.SqUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static int igId = 5;
	private static ItemGroup newGroup;
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		
		igId = 5;
		newGroup = new ItemGroup(55,"Saved Item Group 999");
	}
	
	public static void main(String[] args) {
	  List<ItemGroup> groups = itemGroupService.getAll();
	  SqUtils.print(groups);
	  
	  System.out.println("---------------");
	  
	  ItemGroup group = itemGroupService.get(igId);
	  SqUtils.print("group", group);
	  
	  boolean isSaved = itemGroupService.save(newGroup);
	  SqUtils.print("isSave",isSaved);
	  
	}
}
