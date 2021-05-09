package shopping;

import java.time.LocalDate;
import java.time.Month;

/*
 * Utility of Order class
 * Normally: Utility is place where contains utility methods
 * No cares created class's object 
 */
public class OrderUtils {
	public static double export(Order order) {
		double totoOfMoney = 0;

		ItemDetail[] ids = order.getItemDetails();
		// for index
		// for(int i = 0; i < ids.length; i++) {
		// ItemDetail id = ids[i];
		// }
		// for each
		for (ItemDetail id : ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() * quantity;
			if (LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderDate().toLocalDate()) && item.getCost() > 590) {
				idCost *= 0.9;
			}
			totoOfMoney += idCost;
		}
		return totoOfMoney;
	}
}
