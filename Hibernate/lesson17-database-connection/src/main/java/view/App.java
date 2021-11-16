package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemService;
import service.ItemServiceImpl;
import static utils.SqlUtils.*;

public class App {
	private static int igID;
	private static ItemService itemgroupService;
	private static ItemGroup newGroup;
	
	static {
		igID=2;
		itemgroupService = new ItemServiceImpl();
		
		newGroup = new ItemGroup(123, "saved item group 153");
	}

	public static void main(String[] args) {
		List<ItemGroup> items = itemgroupService.getAll();
		print(items);
		
		System.out.println("\n ============\\\\\\============ \n");
		ItemGroup group = itemgroupService.get(igID);
		
		print("group",group);
		
//		boolean isSaved = itemgroupService.save(newGroup);
//		print("isSave",isSaved);
		
		
		boolean isSaveOrUpdate = itemgroupService.saveOrUpdate(newGroup);
		print("isSaveOrUpdate",isSaveOrUpdate);
	}
}
