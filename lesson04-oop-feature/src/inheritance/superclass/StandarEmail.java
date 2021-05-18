package inheritance.superclass;

public class StandarEmail extends AbstractEmail{
    @Override
    void login() {
	   System.out.println("StandardEmail >> login ...");
	
    }
}