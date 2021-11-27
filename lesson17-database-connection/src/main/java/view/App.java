package view;

import persistence.Employee;
import persistence.Item;
import persistence.ItemGroup;
import persistence.ItemGroupDto;
import service.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static utils.SqlUtils.print;

public class App {
    private static int igId;
    private static String igName;
    private static String igNameInjection;
    private static String email;
    private static String password;
    private static LocalDate orderDate;
    private static ItemGroup newGroup;

    private static ItemGroupService itemGroupService;
    private static ItemService itemService;
    private static EmployeeService employeeService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
        itemService = new ItemServiceImpl();
        employeeService = new EmployeeServiceImpl();

        igId = 5;
        igName = "Áo";
        igNameInjection = "xyz' OR '1=1";
        email = "terry@gmail.com";
        password = "test123";
        orderDate = LocalDate.of(2020, Month.DECEMBER, 18);
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

        System.out.println("=======================");

        List<ItemGroup> groupsByName = itemGroupService.get(igNameInjection);
        print(groupsByName);

        System.out.println("=======================");

        List<Item> itemsByIgName = itemService.get(igName);
        print(itemsByIgName);

        System.out.println("=======================");

        List<Item> itemsByOrderDate = itemService.get(orderDate);
        print(itemsByOrderDate);

        System.out.println("=======================");

        List<ItemGroupDto> itemsByIgId = itemGroupService.getItemsByItemGroupId();
        print(itemsByIgId);

        System.out.println("=======================");

        Employee regEmp = employeeService.singup(email, password);
        print("regEmp", regEmp);

        System.out.println("=======================");

        Employee signingUpAccount = employeeService.signin(email, password);
        print("signingUpAccount", signingUpAccount);
    }
}
