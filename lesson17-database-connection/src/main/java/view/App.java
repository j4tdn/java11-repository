package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import static utils.SqlUtils.*;

public class App {
	private static int igId;
	private static ItemGroup newGroup;
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		
		igId = 5;
		
		newGroup = new ItemGroup(999, "Saved Item Group 159");
	}
	
	public static void main(String[] args) {
		 List<ItemGroup> groups = itemGroupService.getAll();
		 print(groups);

		 System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		 
		 ItemGroup group = itemGroupService.get(igId);
		 print("group", group);
		 
		 System.out.println("\n == \\\\\\\\\\\\\\ == \n");
		 
		 boolean saveOrUpdate = itemGroupService.saveOrUpdate(newGroup);
		 print("saveOrUpdate", saveOrUpdate);
	}
}
