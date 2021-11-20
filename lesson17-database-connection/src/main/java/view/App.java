package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import utils.SqlUtils;

public class App {
	private static ItemGroupService itemGroupService;
	private static int igID;
	private static ItemGroup newGroup;
	
	
	static {
		itemGroupService=new ItemGroupServiceImpl();
		igID=5;
		newGroup=new ItemGroup(991, "Saved Item Group 992");
	}
	
	public static void main(String[] args) {
		List<ItemGroup> groups=itemGroupService.getAll();
		SqlUtils.print(groups);
		
		
		System.out.println("\n==\\\\==\n");
		ItemGroup group=itemGroupService.get(igID);
		SqlUtils.print("group",group);
		
		System.out.println("\n==\\\\==\n");
		boolean isSaved=itemGroupService.saveOrUpdate(newGroup);
		SqlUtils.print("isaved",isSaved);
	
	}
	
	
	
}
