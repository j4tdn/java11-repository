package inheritance.basic;

public class App {
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println("Number: "+ child.number);
		child.text();
		child.log("06.06.2021");
	}
}
