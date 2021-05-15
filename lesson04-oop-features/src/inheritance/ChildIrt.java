package inheritance;

public class ChildIrt extends ParentIrt {
//	@Override ( Chỉ ghi được khi hàm đó đã có ở class cha ) 
	int number = 12;
	String text = "child";

	@Override
	void log() {
		System.out.println("Log in Child class !");
	}
}
