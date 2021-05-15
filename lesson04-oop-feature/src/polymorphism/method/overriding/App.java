package polymorphism.method.overriding;

public class App {
	public static void main(String[] args) {
		ChildPmo cp = new ChildPmo();
		cp.getItSkills();
		System.out.println("Skill: " + cp.getItSkills());
	}
}
