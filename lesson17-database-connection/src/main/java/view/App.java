package view;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import connection.DBManager;
import connection.DBProvider;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import utils.SqlUtils;

public class App {
	private static int igId = 10;
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		// Connection
		Connection connection = DBManager.getConnection();
		System.out.println(connection);
		Properties props = DBProvider.getFrops();
		System.out.println(props.get("URL"));
		
		// 
		ItemGroupService service = new ItemGroupServiceImpl();
		List<ItemGroup> groups = service.getAll();
		SqlUtils.print(groups);
		
		//
		SqlUtils.print("get by igId", itemGroupService.get(igId));
		boolean save = itemGroupService.saveOrUpdate(new ItemGroup(10, "Ghét"));
		System.out.println(save);
	}
}
