package data1;

public class Ex05 {
    public static void main(String[] args){
        Integer a = 10;
        Integer b = 20;
        swap(a, b);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        //final 
        final int number = 100;
        
        
        final Digit d1 = new Digit(20);
        Digit d2 = new Digit(30);
        //d1 = d2 (error)
        d1.value = 30;
    }
    private static void swap(Integer f, Integer s){
        Integer tmp = f;
        f = s; 
        s = tmp;
    }
    
}
