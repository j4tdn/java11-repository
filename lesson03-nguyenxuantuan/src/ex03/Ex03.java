package ex03;
import java.util.Scanner;

public class Ex03 {
    static int sh,sc;
    
    public static void main(String[] args) {
        int arr[][] = new int[10][10];        
        Input(arr);
        System.out.println(YenNgua(arr, sh, sc));
    }

    public static void Input(int arr[][]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so hang: ");
        sh = input.nextInt();
        System.out.print("Nhap so hang: ");
        sc = input.nextInt();
        for(int i=0; i<sh; i++) {
            for(int j=0; j<sc; j++) {
                System.out.print("Nhap phan tu [" +i+ " ; " +j+ "] = ");
                arr[i][j] = input.nextInt();
            }
        }
    }

    
    public static boolean YenNgua(int arr[][], int sh, int sc) {
    	int minhang[] = new int[10];
        int maxcot[] = new int[10];
        for (int i=0; i<sh; i++) {
            minhang[i] = arr[i][0];
            for(int j=0; j<sc; j++) {
                if (minhang[i] > arr[i][j]) {
                    minhang[i] = arr[i][j];
                }
            }
        }

        for (int j=0; j<sc; j++) {
            maxcot[j] = arr[0][j];
            for(int i=0; i<sh; i++) {
                if (maxcot[j] < arr[i][j]) {
                    maxcot[j] = arr[i][j];
                }
            }
        }

        for (int i=0; i<sh; i++) {
            for (int j=0; j<sc; j++) {
                if((arr[i][j] == minhang[i]) && (arr[i][j] == maxcot[j])) {
                    return true;
                }   
            }
        }
		return false;
    }

}


