package demo;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class App2 {

    private static final ItemGroupService itemGROUP_SERVICE;

    static {
        itemGROUP_SERVICE = new ItemGroupServiceImpl();
    }
    public static void main(String[] args) {
        itemGROUP_SERVICE.demoSlvCache();
    }
}
