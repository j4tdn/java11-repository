package shopping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Order {

	private Customer customer;
	private ItemDetail[] itemdetails;
	private LocalDateTime orderDate;
	
	public Order() {
		
	}

	public Order(Customer customer, ItemDetail[] itemdetails, LocalDateTime orderDate) {
		super();
		this.customer = customer;
		this.itemdetails = itemdetails;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", itemdetails=" + Arrays.toString(itemdetails) + ", orderDate="
				+ orderDate + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ItemDetail[] getItemdetails() {
		return itemdetails;
	}

	public void setItemdetails(ItemDetail[] itemdetails) {
		this.itemdetails = itemdetails;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
		public double export()
		{
			double totolOfMoney=0;
			
			ItemDetail[] ids = getItemdetails();
			for(ItemDetail id : ids)
			{
				Item item = id.getId();
				int quality = id.getQuantity();
				
				double idCost= item.getCost()*quality;
				if(item.getCost()>590 && LocalDate.of(2021,Month.MAY, 8).isEqual(getOrderDate().toLocalDate()))
				{
					idCost *= 0.9;
				}
				totolOfMoney+= idCost;
				
			}
			return totolOfMoney;
		}
	public void print(int a)
	{
		System.out.println(this.getCustomer().getName());
		System.out.println("a: "+a);
	}
}
