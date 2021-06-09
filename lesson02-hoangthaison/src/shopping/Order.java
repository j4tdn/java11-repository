package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Order {

	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime orderdate;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetails=" + Arrays.toString(itemDetails) + ", orderdate="
				+ orderdate + "]";
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
	public LocalDateTime getOrderDate() {
		return orderdate;
	}
	public void setOrderDate(LocalDateTime orderdate) {
		this.orderdate = orderdate;
	}
	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime orderdate) {
		super();
		this.customer = customer;
		this.itemDetails = itemDetails;
		this.orderdate = orderdate;
	}
	public double export() {
		double totalOfMoney = 0;
		
		ItemDetail[] ids = getItemDetails();		
		for (ItemDetail id: ids){
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() * quantity;
			if(item.getCost() > 590 && LocalDate.of(2021,Month.MAY,8).isEqual(getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
			totalOfMoney += idCost;
		}
		return totalOfMoney;
	}
}
