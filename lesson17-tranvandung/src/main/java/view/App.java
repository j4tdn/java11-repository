package view;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupDto;
//import service.EmployeeService;
//import service.EmployeeServiceImpl;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App {

	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	// public static EmployeeService employeeService;
	public static LocalDate localDate;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		// employeeService = new EmployeeServiceImpl();
		localDate = LocalDate.of(2020, 12, 18);
	}

	public static void main(String[] args) {

		System.out.println("====1====");

		List<ItemDto> listItemDto = itemService.getItemDto(localDate);
		SqlUtils.print(listItemDto);

		System.out.println("====2====");

		List<ItemGroupDto> listItemGroupDto = itemGroupService.getItemGroup();
		SqlUtils.print(listItemGroupDto);
		
		System.out.println("====3===");
		List<String> top3list = itemService.getTop3ItemsName(2020);
		SqlUtils.print(top3list);
	}
}