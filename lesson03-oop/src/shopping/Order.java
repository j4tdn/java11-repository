package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Order {
	public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime oderDate) {
		super();
		this.customer = customer;
		this.itemDetails = itemDetails;
		this.oderDate = oderDate;
	}

	private Customer customer;
	private ItemDetail[] itemDetails;
	private LocalDateTime oderDate;

	public Order() {

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

	public LocalDateTime getOderDate() {
		return oderDate;
	}

	public void setOderDate(LocalDateTime oderDate) {
		this.oderDate = oderDate;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetails=" + Arrays.toString(itemDetails) + ", oderDate="
				+ oderDate + "]";
	}
}
