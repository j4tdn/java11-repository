package shopping;

import java.time.LocalDateTime;


public class App {
	public static void main(String[] args) {
		/**
		 *  c1: KH1, adam, 123, DA NANG
 			c2: KH2, trung, 345, newyork	
		 * i1: SS10+, Android, Black, 600
 			i2: SS20U, Android, Green, 800
 			i3: IP4, IOS, Black, 300
 			i4: IP10, IOS, Gold, 1000
 			i5: WP10, WP, White, 400
		 */
		
		
		Customer c1 = new Customer("KH1", "Adam", "123", "Danang");
		Customer c2 = new Customer("KH2", "TRUNG", "324", "Newyork");
		
		Item i1 = new Item("SS10", "Adroid", "Black", 620);
		Item i2 = new Item("SS20", "Adroid", "Green", 530);
		Item i3 = new Item("IP4", "IOS", "Black", 280);
		Item i4 = new Item("IP10", "IOS", "Gold", 880);
		Item i5 = new Item("WP10", "WP", "White", 560);
		
		
		Order o1 = new Order(c1, new ItemDetail[] {
				new ItemDetail(i1, 3),
				new ItemDetail(i4, 5),
				new ItemDetail(i2, 1)
		}, LocalDateTime.of(2021, 5, 8, 10, 10));
		
		Order o2 = new Order(c2, new ItemDetail[] {
				new ItemDetail(i3, 2),
				new ItemDetail(i5, 1),
		}, LocalDateTime.of(2021, 5, 7, 13, 0));
		
		Order o3 = new Order(c2, new ItemDetail[] {
				new ItemDetail(i4, 1),
		}, LocalDateTime.of(2021, 5, 8, 15, 0));
		
		
		
		System.out.println("Order 1: " + OderUtils.export(o1));
		System.out.println("Order 2: " + OderUtils.export(o2));
		System.out.println("Order 3: " + OderUtils.export(o3));
		
		

		//write method support in Order class: no-parameter
		//write method export in Another class: export(order)
		
		
	}
}
