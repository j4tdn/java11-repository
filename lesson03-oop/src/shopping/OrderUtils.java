package shopping;

import java.time.LocalDate;
import java.time.Month;

//untiliti of Order class
public class OrderUtils {
	
	public static double export(Order order) {
		double totalOFMoney = 0;
		ItemDetail[] ids = order.getItemDetails();
		for (ItemDetail id : ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost()*quantity;
			if(item.getCost()> 590 &&  LocalDate.of(2021, Month.MAY, 8).isEqual(order.getOrderday().toLocalDate())) {
				idCost *= 0.9;
			}
				totalOFMoney += idCost;
		}
		return totalOFMoney;
	}
}
