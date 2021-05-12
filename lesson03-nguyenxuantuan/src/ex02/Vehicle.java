package ex02;

public class Vehicle {
	private int cylinder;
    private double price;
    private String model,ownerName;
    public Vehicle() {
    	
    }
	
	

	public Vehicle(int cylinder, double price, String model, String ownerName) {
		super();
		this.cylinder = cylinder;
		this.price = price;
		this.model = model;
		this.ownerName = ownerName;
	}

	public int getCylinder() {
		return cylinder;
	}



	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

	@Override
	public String toString() {
		return "Vehicle [cylinder=" + cylinder + ", price=" + price + ", model=" + model + ", ownerName=" + ownerName
				+ "]";
	}


	public double tax(){
	        double tax;
	        if(cylinder<100) 
            tax = price*0.01;
	        else if (cylinder >= 100 && cylinder<=200) tax = price * 0.03;
	        else tax = price * 0.05;
	        return tax;
	}
	 void showTax(){
	        System.out.printf("%10s %6s %7d %10.2f %8.2f \n ",ownerName,model,cylinder,price,tax());
	    }
	 

	
	

}
