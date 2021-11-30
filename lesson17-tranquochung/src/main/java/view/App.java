package view;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupAndItemDto;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {

	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	public static LocalDate localDate;
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		localDate = LocalDate.of(2020, 12, 18);
	}

	public static void main(String[] args) {
		List<ItemDto> listItemDto = itemService.getItemDto(localDate);
		listItemDto.forEach(System.out::println);

		System.out.println("===========================");

		List<ItemGroupDto> listItemGroupDto = itemGroupService.getItemGroup();
		listItemGroupDto.forEach(System.out::println);

		System.out.println("===========================");

		List<String> listStringItem = itemService.getItem(2020);
		listStringItem.forEach(System.out::println);

		System.out.println("===========================");

		List<ItemGroupAndItemDto> list = itemService.getAllItembyAllItemGroup();
		list.forEach(System.out::println);
	}
}
