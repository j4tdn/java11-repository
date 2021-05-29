package shopping;

import java.time.LocalDate;
import java.time.Month;

/*
 * Utility of Order class 
 */
public class OrderUtils {
	
	private OrderUtils() {
	
	}
	public static double export(Order order) {
		double totolOfMoney = 0;

		ItemDetail[] ids = order.getItemDetails();

		// For each
		for (ItemDetail id : ids) {
			
			Item item = id.getItem();
			int quantity = id.getQuantity();

			double idCost = item.getCost() * quantity;
			if (item.getCost() > 590 && LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totolOfMoney += idCost;
		}
		return totolOfMoney;
	}
}
