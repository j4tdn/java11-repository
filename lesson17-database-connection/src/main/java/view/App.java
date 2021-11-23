package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import utils.SqlUtils;

public class App {

	private static ItemGroupService itemGroupService;
	private static ItemGroup newGroup;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		newGroup = new ItemGroup(909, "Saved");
	}
	
	public static void main(String[] args) {

		List<ItemGroup> groups = itemGroupService.getAll();
		SqlUtils.print(groups);
		
		System.out.println("\n ==\\\\\\== \n");
		
		ItemGroup group = itemGroupService.get(2);
		SqlUtils.print("group", group);
		
		System.out.println("\n ==\\\\\\== \n");
		
		boolean isSaved = itemGroupService.update(newGroup);
		SqlUtils.print("isSaved", isSaved);
		
		System.out.println("\n ==\\\\\\== \n");
		List<ItemGroup> groupsByName = itemGroupService.get("'xyz' OR '1=1'");
		SqlUtils.print(groupsByName);
		
		System.out.println("\n ==\\\\\\== \n");
		
	}
}
