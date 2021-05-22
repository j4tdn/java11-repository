package ex05;

import java.util.ArrayList;

public class Customer {
	private String id;
	private String fullName;
	private String phoneNumber;
	private String address;
	private ArrayList<Book> cart = new ArrayList<Book>();

	public Customer() {
	}

	public Customer(String id, String fullName, String phoneNumber, String address, ArrayList<Book> cart) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Book> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Book> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", cart=" + cart + "]";
	}

}
