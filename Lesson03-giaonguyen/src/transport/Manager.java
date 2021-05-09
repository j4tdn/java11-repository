package transport;

import java.util.Arrays;
import java.util.Scanner;

public class Manager {
		
	private User user;
	private Vehicle vehicle;
	
	public Manager() {
		
	}

	public Manager(User user, Vehicle vehicle) {
		super();
		this.user = user;
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Manager [user=" + user + ", vehicle=" + vehicle + "]";
	}
	
	

	
}
