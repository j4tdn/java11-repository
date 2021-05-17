package bai04;

public class App {
 public static void main(String[] args) {
	People p1 = new Manager();
	p1.Input();
	
	
	People p2 = new imployee();
	p2.Input();
	
	
	People p3 = new imployee();
	p3.Input();
	
	People p4 = new Leader();
	p4.Input();
	
	p1.output();
	p2.output();
	p3.output();
	p4.output();
}
}
