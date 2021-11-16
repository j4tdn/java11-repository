package view;

import java.util.List;

import persistence.ItemGroup;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {
	
	private static ItemService itemService;
	
	static {
		itemService = new ItemServiceImpl();
	}
	
	public static void main(String[] args) {

		List<ItemGroup> groups = itemService.itemGroups();
		SqlUtils.print(groups);
		
	}
}
