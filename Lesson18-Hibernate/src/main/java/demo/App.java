package demo;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

public class App {

    private static ItemGroupService itemGroupService;
    private static ItemService itemService;
    static {
      itemGroupService = new ItemGroupServiceImpl();
      itemService = new ItemServiceImpl();
    }
    public static void main(String[] args) {
        System.out.println(itemGroupService.getAll());
    }
}
