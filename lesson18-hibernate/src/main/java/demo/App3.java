package demo;

import java.util.List;

import persistence.Item;
import service.ItemService;
import service.ItemServiceImpl;
import utils.SqlUtils;

public class App3 {
	private static ItemService itemService;
	
	static {
		itemService = new ItemServiceImpl();
	}
	
	public static void main(String[] args) {
		List<Item> items = itemService.getAll();
		System.out.println("Liệt kê thông tin mặt hàng 1");
		System.out.println(items.get(0));
		System.out.println("Liệt kê tất cả các mặt hàng chứa thông tin loại hàng &&& kích cỡ");
		SqlUtils.print(items.get(0).getItemDetails());
	}
}
