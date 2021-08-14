package Ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
        // tam giac doi xung
        Scanner s = new Scanner(System.in);
        int n;
        System.out.print("moi nhap n: ");
        n = s.nextInt();
        for(int i =1; i<n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print(j);
            }
            for(int k = 1; k< 2*(n-i); k++){
                System.out.print(" ");
            }
            for(int l = 2*n-i; l<2*n; l++){
                System.out.print(l);
            }
            System.out.println("");
        }
        
        for(int i = 1; i< 2*n; i++){
            System.out.print(i);
        }
          System.out.println("");
          
        for(int i = n-1; i>=1; i--){
            for(int j= 1; j<=i; j++){
                System.out.print(j);
            }
            for(int k = 1; k< 2*(n-i); k++){
                System.out.print(" ");
            }
            for(int l = 2*n-i; l<2*n; l++){
                System.out.print(l);
            }
            System.out.println("");
        }
        
    }
}
