package demo;

import static utils.SqlUtils.*;

import java.util.List;

import persistence.Item;
import persistence.ItemDetail;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import persistence.Size;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {
	
	private static int itemId;
	private static int itemGroupId;

	private static ItemGroupService itemGroupService = new ItemGroupServiceImpl();
	private static ItemService itemService = new ItemServiceImpl();

	static {
		itemId = 1;
		itemGroupId = 1;
		
		// itemGroupService = new ItemGroupServiceImpl();
		// itemService = new ItemServiceImpl();
	}

	public static void main(String[] args) {
		// Câu 1: Liệt kê tất cả các loại hàng
		List<ItemGroup> itemGroups = itemGroupService.getAll();
		print(itemGroups);
		
		breakLine("Câu 1: Liệt kê tất cả các loại hàng");
		
		ItemGroup itemGroup = itemGroups.get(itemGroupId);
		List<Item> itemsByIgAtIdx1 = itemGroup.getItems();
		System.out.println(itemsByIgAtIdx1);
		
		breakLine("Câu 2||4: Liệt kê tất cả các mặt hàng chứa thông tin loại hàng &&& kích cỡ");
		List<Item> items = itemService.getAll();
		print(items);
		
		System.out.println("======================C4============================");
		Item firstItem = items.get(1);
		List<ItemDetail> itemDetails =  firstItem.getItemDetails();
		System.out.println("itemDetails size: " + itemDetails.size());
		
		Size size = itemDetails.get(0).getSize();
		System.out.println("Size#size: " + size);
		
		breakLine("Câu 3: Liệt kê tất các mặt hàng theo MaMH");
		Item item = itemService.getItem(itemId);
		print("item", item);
		
		// Câu 4: Liệt kê tất cả các mặt hàng chứa thông tin kích cỡ mặt hàng
		
		breakLine("Câu 5: Đếm số lượng các mặt hàng theo từng loại hàng");
		List<ItemGroupDto> itemsByIgId = itemGroupService.getItemsByItemGroupId();
		print("itemsByIgId", itemsByIgId);
	}
}
