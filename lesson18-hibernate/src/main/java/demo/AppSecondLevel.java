package demo;

import dao.ItemGroupDao;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class AppSecondLevel {
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService=new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		itemGroupService.demoSlvCache();
		
	}
}
