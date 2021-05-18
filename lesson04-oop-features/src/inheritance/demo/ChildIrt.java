package inheritance.demo;

public class ChildIrt extends ParentIrt{
	int number = 99;
	String text = "child";
	
	
	// dung co ghi chu override thi cung da override
	@Override
	void log() {
		System.out.println(" Log in Child class ! ");
	}

}
