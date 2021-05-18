package inheritance.demo;

public class App {
	public static void main(String[] args) {
		ParentIrt parentIrt = new ChildIrt();
		System.out.println(parentIrt.number);
		System.out.println(parentIrt.text);
		parentIrt.log();

		ChildIrt ci =  new ChildIrt();
		ci.isHappy();
	}
}
