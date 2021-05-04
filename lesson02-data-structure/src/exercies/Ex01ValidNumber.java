package exercies;

import java.util.Scanner;

public class Ex01ValidNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String txt = null;
		int count =0;
		do{
			txt = sc.nextLine();
			
			if(txt.matches("[0-9]+")) {
				break;
			}
		    count++ ;
		    if(count == 3) {
					System.out.println("Sai 3 times");
				return;
			}
			
		}while(true);
		System.out.println("Value "+ txt);
	}

}
