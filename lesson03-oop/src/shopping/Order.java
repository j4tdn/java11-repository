package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetail;
	private LocalDateTime orderDate;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, ItemDetail[] itemDetail, LocalDateTime orderDate) {
		super();
		this.customer = customer;
		this.itemDetail = itemDetail;
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ItemDetail[] getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail[] itemDetail) {
		this.itemDetail = itemDetail;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetail=" + itemDetail + ", datetime=" + orderDate + "]";
	}



}
