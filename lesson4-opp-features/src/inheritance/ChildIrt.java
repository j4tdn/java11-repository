package inheritance;

public class ChildIrt extends ParentIrt{
	int number = 99;
	String text = "child";
	
	@Override
	void log() {
		System.out.println("Log in Child class !");
	}
}
