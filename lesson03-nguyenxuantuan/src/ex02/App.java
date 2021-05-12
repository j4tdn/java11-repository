package ex02;
import java.util.Scanner;
public class App {
	
        public static void inputVehicle(Vehicle vehicle){
        	Scanner ip = new Scanner(System.in);
        	System.out.print("Nhap ten chu xe: ");
        	vehicle.setOwnerName(ip.nextLine());
    	    System.out.print("Nhap loai xe: ");
    	    vehicle.setModel(ip.nextLine());
            System.out.print("Nhap dung tich xe: ");
            vehicle.setCylinder(ip.nextInt());
            System.out.print("Nhap tri gia xe: ");
            vehicle.setPrice(ip.nextDouble());ip.nextLine();

        }

    public static void main(String[] args) {
    	Scanner ip = new Scanner(System.in);
        Vehicle v[]= null;
        int a,n=0;
        boolean flag = true;
 
        do{
        	System.out.println("MENU:");
    		System.out.println("1.Nhap thong tin");
    		System.out.println("2.Xuat bang ke khai");
    		System.out.println("3.Thoat");
    		System.out.print("Nhap lua chon:");
            a =ip.nextInt();
            switch (a){
                case 1:
                    System.out.print("Nhap so luong xe: ");
                    n=ip.nextInt();
                    v= new Vehicle[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Xe thu " + (i+1));
                        v[i] = new Vehicle();
                        inputVehicle(v[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%6s %6s %6s %6s %8s \n","Ten chu xe","Loai xe","Dung tich","Tri gia","Thue phai nop");
                    System.out.println("=========================================================================");
                    for (int i = 0; i < n; i++) {
                        v[i].showTax();
                    }
                    break;
                default:
                    System.out.println("Bye");
                    flag=false;
                    break;
            }
        }while (flag);
    }
}