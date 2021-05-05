package ifelse.switchcase;
import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    
    // }
    // public static boolean ValidNumber(int n){
        Scanner sc = new Scanner(System.in);
        int count = 0;
		String text = null;
        do {
            System.out.println("Enter number");
            text = sc.nextLine();
            if(text.matches("[0-9]+")){
                break;
            }
            count ++;
            if(count == 3) {
            	System.out.println("Wrong text exceeds 3 times");
            }
        }
        while(true);
        System.out.println("Value: " + text);
    }
       
}