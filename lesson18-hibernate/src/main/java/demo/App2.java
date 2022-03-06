package demo;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class App2 {
private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	
	public static void main(String[] args) {
		itemGroupService.getAll().forEach(System.out::println);
	}
}
