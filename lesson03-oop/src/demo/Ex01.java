package demo;
import bean.Rectangle;

public class Ex01 {
	   
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.setWidth(12);
        r1.setHeight(12);
 
    

        System.out.println("r1: " + r1.toString());

        Rectangle r2 = new Rectangle(9,7);
        System.out.println("r2: " + r2.toString());

    }
    
}
