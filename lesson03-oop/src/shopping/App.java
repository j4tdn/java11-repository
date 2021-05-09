
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("KH1", "Adam", "123", "NewYork");
        Customer c2 = new Customer("KH2", "Kate", "234", "California");

        Item i1 = new Item("SS10+", "Android", "Black", 620);
        Item i2 = new Item("SS20U", "Android", "Green", 820);
        Item i3 = new Item("IP4", "IOS", "White", 250);
        Item i4 = new Item("IP12", "IOS", "Blue", 720);


        Order o1 = new Order(c1, new ItemDetail[]{
            new ItemDetail(i1, 3),
            new ItemDetail(i4, 5),
            new ItemDetail(i3, 2),



        }, LocalDateTime.of(2021, 5, 8, 10, 10, 10));
        Order o2 = new Order(c2, new ItemDetail[]{
            new ItemDetail(i1, 2),
            new ItemDetail(i2, 1),
            new ItemDetail(i4, 4),



        }, LocalDateTime.of(2021, 5, 7, 12, 10, 4));
        Order o3 = new Order(c2, new ItemDetail[]{
            new ItemDetail(i3, 3),
            new ItemDetail(i4, 1),
            new ItemDetail(i2, 2),



        }, LocalDateTime.of(2021, 5, 8, 3, 13, 44));

        System.out.println("Order 1: " + OrderUtils.export(o1));
        System.out.println("Order 2: " + OrderUtils.export(o2));
        System.out.println("Order 3: " + OrderUtils.export(o3));

    }
    
}
