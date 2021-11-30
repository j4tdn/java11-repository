package view;

import static utils.SqlUtils.print;

import java.time.LocalDate;
import java.util.List;

import persistence.ItemDetailDto;
import persistence.ItemDetailGroupDto;
import persistence.ItemDto;
import service.ItemDetailService;
import service.ItemDetailServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ItemService itemService;
	private static ItemDetailService itemDetailService;
	
	private static LocalDate orderDate;
	private static String year;

	static {
		itemService = new ItemServiceImpl();
		itemDetailService = new ItemDetailServiceImpl();
		
		orderDate = LocalDate.of(2020, 12, 18);
		year = "2020";

	}
	
    public static void main( String[] args )
    {
    	System.out.println("\n1. ==\\\\\\== \n");
		
		List<ItemDto> itemsByOrderDate = itemService.get(orderDate);
		print(itemsByOrderDate);
		
		System.out.println("\n2. ==\\\\\\== \n");
		
		List<ItemDetailDto> inventory = itemDetailService.getInventory();
		print(inventory);
		
		System.out.println("\n3. ==\\\\\\== \n");
		
		List<String> top3 = itemService.getTop3(year);
		print(top3);
		
		System.out.println("\n4. ==\\\\\\== \n");
		
		List<ItemDetailGroupDto> details = itemService.getItemByIg();
		print(details);
    }
}
