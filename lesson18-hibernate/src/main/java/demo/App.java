package demo;

import java.util.List;

import org.hibernate.SessionFactory;
import static utils.SqlUtils.*;

import persistence.Item;
import persistence.ItemGroup;
import provider.HibernateProvider;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {
	
	private static ItemGroupService itemGroupService;
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
	}
}