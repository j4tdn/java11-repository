package functional;

public class Oddcondition implements Condition{

    @Override
    public boolean test(int a) {
        System.out.println("Oddcondition" + a);
        return a%2 !=0;
    }
    
}