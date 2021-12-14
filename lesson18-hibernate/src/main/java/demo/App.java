package demo;

import persistence.Item;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

import java.util.List;

import static utils.SqlUtils.breakLine;
import static utils.SqlUtils.print;

public class App {

    private static ItemGroupService itemGroupService;
    private static ItemService itemService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
        itemService = new ItemServiceImpl();
    }

    public static void main(String[] args) {
        List<ItemGroup> itemGroups = itemGroupService.getAll();
        print(itemGroups);

        breakLine("itemsByIgAtIdx1");

        ItemGroup itemGroup = itemGroups.get(1);
        List<Item> itemsByIgAtIdx1 = itemGroup.getItems();
        System.out.println(itemsByIgAtIdx1);

        breakLine("items");

        List<Item> items = itemService.getAll();
        print(items);
    }
}
