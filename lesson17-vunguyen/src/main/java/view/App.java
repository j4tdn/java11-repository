package view;

import persistence.ItemByDateDto;
import persistence.ItemByItemGroupDto;
import persistence.ItemGroupDto;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;
import utils.DateUtils;
import utils.SqlUtils;

import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static ItemService itemService;
    private static ItemGroupService itemGroupService;

    static {
        itemService = new ItemServiceImpl();
        itemGroupService = new ItemGroupServiceImpl();
    }

    public static void main(String[] args) {
        System.out.println("Nhap date theo dinh dang yyyy-mm-dd: ");
        String dateString = scanner.nextLine();
        List<ItemByDateDto> itemsByDate = itemService.get(DateUtils.toLocalDate(dateString));

        System.out.println("=======================");

        List<ItemGroupDto> availableItemsByIgId = itemGroupService.getAvailableItemsByGroupId();
        SqlUtils.print(availableItemsByIgId);

        System.out.println("=======================");

        System.out.println("Nhap nam: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        List<String> itemsBySale = itemService.getItemBySale(year);
        SqlUtils.print(itemsBySale);

        System.out.println("=======================");
        List<ItemByItemGroupDto> itemsByItemGroup = itemService.getItemByItemGroups();
        SqlUtils.print(itemsByItemGroup);
    }
}
