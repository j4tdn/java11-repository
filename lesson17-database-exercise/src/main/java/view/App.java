package view;

import static utils.SqlUtils.print;

import java.util.List;

import persistence.Item;
import persistence.ItemGroup;
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
	static {
		igService = new ItemGroupServiceImpl();
		itemService = new ItemServiceImpl();
		igNew = new ItemGroup(112, "Nich");
	}

	public static void main(String[] args) {
		List<ItemGroup> igList = igService.getAll();
		SqlUtils.print(igList);

		System.out.println("==========");

		List<ItemGroup> igByName = igService.get("Áo");
		SqlUtils.print(igByName);

		System.out.println("==========");

		List<Item> item = itemService.get("Áo");
		SqlUtils.print(item);

		System.out.println("==========");
		boolean isSaved = igService.save(igNew);
		SqlUtils.print("isSavae", isSaved);
	}
}
