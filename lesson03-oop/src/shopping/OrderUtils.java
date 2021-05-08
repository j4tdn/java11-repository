package shopping;

import java.time.LocalDate;
import java.time.Month;

public class OrderUtils {
	public double export(Order order) {
		double totolOfMoney = 0;
		
		ItemDetail[] ids = order.getItemDetail();
		for(ItemDetail id:ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			
			double idCost = item.getCost()*quantity;

			if(item.getCost() >590 && LocalDate.of(2021, Month.MAY, 5).isEqual(order.getOrderDate().toLocalDate())) {
				idCost*= 0.9;
			
		}
		totolOfMoney+= idCost;
	}

	return totolOfMoney;

}

}
