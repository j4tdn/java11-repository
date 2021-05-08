package shopping;

import java.time.LocalDateTime;

public class App {
	public static void main(String[] args) {
		/*
		 * c1 : KH1, Adam, 123, NewYork
			c2 : KH2, Kate, 123, California

			i1 : SS10+, Android, Black, 620
			i2 : SS20U, Android, Green, 840
			i3 : IP4, IOS, White, 280
			i4 : IP12, IOS, Black, 880
			i5 : WP8, WindowPhone, Blue, 560
			
			order1 : c1 , {id1(i1,3), id2(i4,1), id3(i2, 1)}, 10:10:10 08.05.2021 
			order2 : c2 , {id1(i3,2), id2(i5,1)} , date_time 20:10:12 07.05.2021 
			order3 : c2 , {id1(i4,1)} , date_time 09:28:32 08.05.2021 
		*/
		
		Customer c1 = new Customer("KH1", "Adam", 123, "NewYork");
		Customer c2 = new Customer("KH2", "Kate", 243, "California");
		
		Item i1 = new Item("SS10+", "Android", "Black", 620);
		Item i2 = new Item("SS20U", "Android", "Green", 840);
		Item i3 = new Item("IP4", "IOS", "White", 280);
		Item i4 = new Item("IP12", "IOS", "Black", 880);
		Item i5 = new Item("WP8", "WindowPhone", "Blue", 560);
		
		Order o1 = new Order(c1, new ItemDetail[] {
				new ItemDetail(i1, 3), // 1674
				new ItemDetail(i4, 5),// 3960
				new ItemDetail(i2, 1) // 756
		}, LocalDateTime.of(2021, 5, 7, 10, 10, 10));
		
		Order o2 = new Order(c2, new ItemDetail[] {
				new ItemDetail(i3, 2),
				new ItemDetail(i5, 1)
		}, LocalDateTime.of(2021, 5, 8, 20, 10, 12));
		
		Order o3 = new Order(c2, new ItemDetail[] {
				new ItemDetail(i4, 1),
		}, LocalDateTime.of(2021, 5, 8, 9, 28, 32));

		System.out.println("Oder 1 : " + OrderUtils.export(o1));
		System.out.println("Oder 2 : " + OrderUtils.export(o2));
		System.out.println("Oder 3 : " + OrderUtils.export(o3));
		//  case 1 : Write method export in Order class : no parameter
		// case 2 : Write method export in Another class : export(order)
	}
}
