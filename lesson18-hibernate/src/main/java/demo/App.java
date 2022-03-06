package demo;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.HibernateItemDao;
import dao.ItemDaoImpl;
import persistence.Item;
import persistence.ItemGroup;
import provider.HibernateProvider;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import utils.SqlUtils;

public class App {
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateProvider.getSessionFactory();
		ItemGroupService service = new ItemGroupServiceImpl();
		List<ItemGroup> itemGroupList = service.getAll();
		SqlUtils.print(itemGroupList.get(0).getItems());
		SqlUtils.print(itemGroupList);
		
		// Caau 2: Liet ke tat ca item
		HibernateItemDao itemService = new ItemDaoImpl();
		List<Item> itemList = itemService.getAll();
		SqlUtils.print(itemList);
		
		// Cau 3: Liet ke tat ca cac mat hang theo MaMH
		Item item3 = itemService.getItem(1);
		SqlUtils.print("Select by MaMh: ", item3);
		
	}
}
