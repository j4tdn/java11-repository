package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import util.SqlUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static int igId ;
	private static String igName;
	private static ItemGroup newGroup;
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		igId = 5;
		igName = "Áo";
		newGroup = new ItemGroup(999, "Save Item Group 123");
	}
	
	public static void main(String[] args) {
		List<ItemGroup> groups =  itemGroupService.getAll();
		SqlUtils.print(groups);
		
		System.out.println("=========== || ====================");
		
		ItemGroup group = itemGroupService.get(igId);
		SqlUtils.print("group : ", group);
		
		System.out.println("=========== || =====================");
		
//		boolean isSaved = itemGroupService.save(newGroup);
//		SqlUtils.print("isSaved", isSaved);
		
//		boolean saveOrUpdate = itemGroupService.saveOrUpdate(group);
//		SqlUtils.print("saveOrUpdate", saveOrUpdate);
		
		System.out.println("=========== || ====================");
		List<ItemGroup> groupsByName =  itemGroupService.get(igName);
		SqlUtils.print(groupsByName);
		
	}
}
