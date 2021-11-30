package view;

import static utils.SqlUtils.print;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemDto;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

/**
 * Hello world!
 *
 */
public class App {
	private static ItemGroupService igService;
	private static ItemService itemService;
	private static ItemGroup igNew;
	private static LocalDate date;
	private static String year;
	static {
		igService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		igNew = new ItemGroup(112, "Nich");
		date = LocalDate.of(2020, 12, 18);
		year = "2020";
	}

	public static void main(String[] args) {
		List<ItemDto> iDto = itemService.getTime(date);
		SqlUtils.print(iDto);
		
		System.out.println("=======================");
		List<ItemGroupDto> igDto = igService.get();
		SqlUtils.print(igDto);
		
		System.out.println("=======================");
		List<Item> item = itemService.getTopQuantity(year);
		SqlUtils.printItem(item);
		
		System.out.println("=======================");
		List<ItemDetail> itemD = itemService.get();
		SqlUtils.print(itemD);
	}
}
