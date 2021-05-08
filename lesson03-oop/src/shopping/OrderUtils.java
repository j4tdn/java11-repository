package shopping;

import java.time.LocalDate;
import java.time.Month;

public class OrderUtils {

	private OrderUtils() {
		// TODO Auto-generated constructor stub
	}

	public static double export(Order order) {
		double totalOfMoney = 0;
		ItemDetail[] ids = order.getItemDetails();
		for (var id : ids) {
			Item item = id.getItem();
			int quatity = id.getQuantity();
			double idCost = item.getCost() * quatity;
			if (item.getCost() > 590 && LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost;
		}
		return totalOfMoney;
	}
}
