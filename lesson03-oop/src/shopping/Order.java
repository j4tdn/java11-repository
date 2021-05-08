package shopping;

import java.time.LocalDateTime;

public class Order {
	private Customer customer;
	private ItemDetail itemDetail;
	private LocalDateTime orderDate;

	public Order() {
	}

	public Order(Customer customer, ItemDetail itemDetail, LocalDateTime orderDate) {
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

	public ItemDetail getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail itemDetail) {
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
		return "Order [customer=" + customer + ", itemDetail=" + itemDetail + ", orderDate=" + orderDate + "]";
	}

	public double export() {
		double totoOfMoney = 0;
		ItemDetail[] ids = getItemDetail();
		
	}

}
