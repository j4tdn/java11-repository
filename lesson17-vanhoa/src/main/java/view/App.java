package view;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import persistence.ItemDto;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceIpml;
import service.ItemService;
import service.ItemServiceIpml;
import utils.SqlUtils;

public class App {
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	static {
		itemGroupService = new ItemGroupServiceIpml();
		itemService = new ItemServiceIpml();
	}
	
	public static void main(String[] args) {
		// 1.
		List<ItemDto> itemDto = itemService.get(LocalDate.of(2020, Month.DECEMBER, 18));
		SqlUtils.print(itemDto);
		
		// 2.
		List<ItemGroupDto> group = itemGroupService.getWithNumberOf();
		SqlUtils.print(group);
	
	}
}
