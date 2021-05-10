package shopping;

import java.time.LocalDate;
import java.time.Month;

/**
 * Utility of Order class 
 * Normally: Utility is place where contains utility methods
 * dua vao truyen vao va tinh toan, k quan tam den doi tuong dang goi
 */
public class OderUtils {
	
	private OderUtils() {
	}
	
	
	//o1, o2, o3
	public static double export(Order order) {
		System.out.println(order.getCustomer());
		
		double totalOfMoney = 0;
		
		ItemDetail[] ids = order.getItemDetails();
//		for(int i = 0; i< ids.length; i++) {
//			ItemDetail id = ids[i];
//		}
		
		//for each
		for(ItemDetail id: ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			
			double idCost = item.getPrice() * quantity;
			if(item.getPrice() > 590 && LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost;
		}
		return totalOfMoney;
	}
}
