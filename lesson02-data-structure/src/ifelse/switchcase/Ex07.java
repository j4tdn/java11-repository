package ifelse.switchcase;
import java.util.Random;
public class Ex07 {
    public static void main(String[] args) {
        String[] data = new String[5];
        Random rd = new Random();
        String text = null;
        int i = 0; 
        
        while(i < 5) {
        	
        	text = "" + (20 + rd.nextInt(11)) ;
            if(contains(data, i, text)) {
                continue;
            }
            data[i++] = text;
       
            System.out.println(text + " ");
        	}
        }
    private static boolean contains(String[] data, int nonNullSize, String text){
        for(int i = 0; i < nonNullSize; i++){
            if(data[i].equals(text)){
                return true;
            }
        }
        return false;
    }
  
}