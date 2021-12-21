package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import persistence.ItemAndItemGroupDto;
import persistence.ItemDto;
import persistence.ItemGroupDto;
import service.ItemService;
import service.ItemServiceImpl;

public class App {
	private static ItemService itemService;
	private static LocalDate localDate;
	private static ItemGroupDao itemGroupDao;
	static {
		itemService = new ItemServiceImpl();
		localDate = LocalDate.of(2020, Month.DECEMBER, 18);
		itemGroupDao = new ItemGroupDaoImpl();
	}

	public static void main(String[] args) {
		// Ex1
		List<ItemDto> list = itemService.get(localDate);
		// Ex2
		List<ItemGroupDto> list2 = itemGroupDao.getItemByItemGroups();
		// Ex3
		List<String> list3 = itemService.getTopOfYear(2020);
		// EX4
		List<ItemAndItemGroupDto> list4 = itemService.getAllItemAndItemGroup();
		printf(list3);
	}

	public static <E> void printf(List<E> list) {
		for (E item : list) {
			System.out.println(item);
		}
	}

}
