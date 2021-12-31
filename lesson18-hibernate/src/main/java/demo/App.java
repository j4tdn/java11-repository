package demo;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import static utils.SqlUtils.*;

public class App {
	private static int itemID;
	private static int ItemGroupId;
	
	private static ItemGroupService itemGroupService;
	private static ItemService itemService;
	
	static {
		itemID=1;
		ItemGroupId=1;
		itemGroupService = new ItemGroupServiceImpl();
		itemService = new  ItemServiceImpl();
	}
	public static void main(String[] args) {
		//Câu 1: liệt kê tất cả mặt hàng
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		print(itemGroups);
		
		
	
		breakLine("2a: Lấy các mặt hàng của từng loại hàng");
		ItemGroup itemGroup =itemGroups.get(ItemGroupId);
		List<Item> itemsByIgAtIdx1 = itemGroup.getItems();
		print(itemsByIgAtIdx1);
		
		
		breakLine("2b || 4: Liệt kê tất cả mặt hàng chứa thông tin loại hàng và chi tiết mặt hàng");
		List<Item> items = itemService.getAll();
		print(items);
		
		breakLine("Cau 3: Liet ke MH theo ma");
		Item item = itemService.getItem(itemID);
		print("Item", item);
		
		
		breakLine("Cau 5: đếm số lượng mặt hàng cảu từng loại hàng");
		List<ItemGroupDto> itemByIgId = itemGroupService.getItemsByItemGroupId();
		print(itemByIgId);
	}
}
