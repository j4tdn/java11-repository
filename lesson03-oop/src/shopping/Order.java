package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Order {
	private Customer customer;
	private ItemDetail[] itemDetail;
	private LocalDateTime orderDate;

	public Order() {
	}

	public Order(Customer customer, ItemDetail[] itemDetail, LocalDateTime orderDay) {
		this.customer = customer;
		this.itemDetail = itemDetail;
		this.orderDate = orderDay;
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

	public void setOrderDay(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemDetail=" + Arrays.toString(itemDetail) + "]";
	}
	//o1,o2,o3: mỗi đối tượng cho 1 kq khác nhau => non-static ( phụ thuộc vào đối tượng )
	public double export() {
		double totalOfMoney = 0;
		ItemDetail[] ids = getItemDetail();
		// for index: for duyệt theo chỉ số 
		//for (int i = 0; i < ids.length; i++) {
		 //ItemDetail id = ids[i];
		//}
		//for each: for này sẽ duyệt theo từng giá trị 
		// duyệt từng phần tử id trong ids 
		for(ItemDetail id: ids) {
			Item item = id.getItem();
			int quantity = id.getQuantity();
			double idCost = item.getCost() * quantity;
			if (item.getCost() > 590 && LocalDate.of(2021, Month.MAY, 8).isEqual(getOrderDate().toLocalDate())) {
				idCost *= 0.9;
			}
					
			totalOfMoney += idCost;
			
		}
		return totalOfMoney; 
		
		
	}

}
