package demo;

import bean.CarAudi;

public class Ex04Static {
	public static void main(String[] args) {
		CarAudi.model = "Audi";
		CarAudi ad1 = new CarAudi("green");
		CarAudi ad2 = new CarAudi("blue");
		
		ad1.setColor("yellow");
		CarAudi.model = "Mazda";
		System.out.println("ad1: " + ad1);
		System.out.println("ad2: " + ad2);
	}

}
