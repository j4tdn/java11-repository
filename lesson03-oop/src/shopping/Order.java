package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime orderday;

	public Order() {

	}

	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime orderday) {

		this.customer = customer;
		this.itemDetails = itemDetails;
		this.orderday = orderday;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ItemDetail[] getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetail[] itemDetails) {
		this.itemDetails = itemDetails;
	}

	public LocalDateTime getOrderday() {
		return orderday;
	}

	public void setOrderday(LocalDateTime orderday) {
		this.orderday = orderday;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetails=" + Arrays.toString(itemDetails) + ", orderday="
				+ orderday + "]";
	}

//	public double export() {
//		double totalOFMoney = 0;
//
//		ItemDetail[] ids = getItemDetails();
//		for (ItemDetail id : ids) {
//			Item item = id.getItem();
//			int quantity = id.getQuantity();
//			double idCost = item.getCost()*quantity;
//			if(item.getCost()> 590 &&  LocalDate.of(2021, Month.MAY, 8).isEqual(getOrderday().toLocalDate())) {
//				idCost *= 0.9;
//			}
//				totalOFMoney += idCost;
//		}
//		return totalOFMoney;
//	}

}
