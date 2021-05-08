package shopping;

import java.time.LocalDate;
import java.time.Month;

/*
 * Utility of Order Class
 * Normally: Utility is place where contains utility methods
 * No cares created objects
 */
public class OrderUtils {
// o1, o2, o3
	public static double export(Order order) {
		double totalOfMoney = 0;
		ItemDetail[] ids = order.getItemDetails();
		for (ItemDetail id : ids) {
			Item item = id.getItem();
			int quantity = id.getQuatity();
			double idCost = item.getCost() * quantity;
			if(item.getCost() > 590 && LocalDate.of(2021, Month.MAY,8).isEqual(order.getOderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost ;
		}

		return totalOfMoney;
	}
}
