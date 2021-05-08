package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime datetime; // worst case 10:10:10 08.05.2021 05.08.2021

	public Order() {
	}

	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime datetime) {
		super();
		this.customer = customer;
		this.itemDetails = itemDetails;
		this.datetime = datetime;
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
		return datetime;
	}

	public void setOrderDate(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	

}
