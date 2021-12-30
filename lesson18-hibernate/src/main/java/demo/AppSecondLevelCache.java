package demo;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class AppSecondLevelCache {
	private static ItemGroupService itemGroupSevice;
	
	static {
		itemGroupSevice = new ItemGroupServiceImpl();
		
	}
	
	public static void main(String[] args) {
		itemGroupSevice.demoSlvCache();
	}
	
}
