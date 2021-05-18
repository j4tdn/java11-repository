package inheritance.superclass;

public class StandardEmail  extends AbstactEmail{

	@Override
	void login() {
		System.out.println("StandardEmail >> login ! ");
	}

}
