package demo;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {

	private static ItemGroupService itemmGroupService;
	private static ItemService itemService;
	
	static {
		itemmGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
	}
	public static void main(String[] args) {
		List<ItemGroup> itemGroups = itemmGroupService.getAll();
		SqlUtils.print(itemGroups);
	
		
		ItemGroup itemGroup = itemGroups.get(1);
		List<Item> itemByIgAtIdx1 = itemGroup.getItems();
		
		
		List<Item> items = itemService.getAll();
		SqlUtils.print(items);
	}
}
