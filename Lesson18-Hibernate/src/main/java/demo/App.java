package demo;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {

    private static final ItemGroupService itemGroupService;
    private static final ItemService itemService;
    static {
      itemGroupService = new ItemGroupServiceImpl();
      itemService = new ItemServiceImpl();
    }
    public static void main(String[] args) {

        System.out.println(itemGroupService.getItemByItemGroupId());


    }
}
