package demo;

import bean.CarAudi;

public class Ex04Static {
	public static void main(String[] args) {
		CarAudi.model = "Audi";
		
		CarAudi ad1 = new CarAudi("red");
		CarAudi ad2 = new CarAudi("black");
		
		ad1.setColor("yellow");
		CarAudi.model = "Bugatti";
		
		System.out.println("ad1: " + ad1);
		System.out.println("ad2: " + ad2);
	}

}
