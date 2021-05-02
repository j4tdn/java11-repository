package data;

public class Ex06 {
    public static void main(String[] args) {
    	Digit a = new Digit(10);
        Digit b = new Digit(20);
        swap(a,b);
        System.out.println("a : "+ a);
        System.out.println("b : "+ b);
    }
    
    public static void swap(Digit first,Digit second) {
    	int tmp = first.value;
    	first.value = second.value;
    	second.value = tmp;
    }
    
    
    //final cannot update value at stack
    // can update value at heap
    
}
