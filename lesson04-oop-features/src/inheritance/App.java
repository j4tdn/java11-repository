package inheritance;

public class App {
	public static void main(String[] args) {
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
	}

}
