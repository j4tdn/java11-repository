package view;

import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

import java.util.List;

import static utils.SqlUtils.print;

public class App {
    private static int igId;
    private static ItemGroup newGroup;
    private static ItemGroupService itemGroupService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
        igId = 5;
        newGroup = new ItemGroup(999, "Saved Item Group 123");
    }

    public static void main(String[] args) {
        List<ItemGroup> groups = itemGroupService.getAll();
        print(groups);

        System.out.println("=======================");

        ItemGroup group = itemGroupService.get(igId);
        print("group", group);

        System.out.println("=======================");

        boolean saveOrUpdate = itemGroupService.saveOrUpdate(newGroup);
        print("isSave", saveOrUpdate);
    }
}
