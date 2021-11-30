package view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import persistence.Item;
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
public class App 
{
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	private static LocalDate orderDate;
	private static int year;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		
		orderDate = LocalDate.of(2020, 12, 18);
		year = 2020;
	}
	
	
    public static void main(String[] args) {
    	
    	System.out.println("=======|1|======");
    	List<ItemDto> itemsByOrderDate = itemService.getItemsByDate(orderDate);
		SqlUtils.print(itemsByOrderDate);
		
		System.out.println("=======|2|======");
		
		List<ItemGroupDto> itemsByItemGroup = itemGroupService.getItemsByItemGroup();
		SqlUtils.print(itemsByItemGroup);
		
		System.out.println("=======|3|======");
		List<String> ThreeItemsBestSeelingOfTheYear = itemService.getThreeItemBestSellingOfTheYear(year);
		SqlUtils.print(ThreeItemsBestSeelingOfTheYear);
		
		System.out.println("=======|4|======");
		List<Item>  statistics = itemService.statistic();
		SqlUtils.print(statistics);
	}
}
