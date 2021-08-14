package Ex02;

import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner(System.in);
    static void nhapAlbum(CD cd) {
        System.out.print("Nhập mã CD: ");
        cd.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập loai CD : ");
        cd.setType(sc.nextLine());
        System.out.print("Nhập tên ca sĩ : ");
        cd.setSingle(sc.nextLine());
        System.out.print("Nhập số lượng bài hát : ");
        cd.setNumberOfSong(sc.nextInt());
        System.out.print("Nhập giá thành : ");
        cd.setPrice(sc.nextFloat());
    }
    public static void main(String[] args) {
        CD cd[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("Bạn chọn làm gì?");
            System.out.println("1.Nhập thông tin CD \n" +
                    "2.Xuất danh sách Album.\n" + "3.Tính tổng giá thành \n" + "4.Tổng số lượng CD \n" +
                    "5.Sắp xếp giảm dần theo giá thành\n"+"6.Sắp xếp tăng dần theo tựa CD\n"+"Nhập số khác để thoát");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Nhập số lượng CD : ");
                    n = sc.nextInt();
                    cd = new CD[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("CD thứ " + (i + 1)+": ");
                        cd[i] = new CD();
                        nhapAlbum(cd[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s %-10s %-20s \n", "Mã CD", "Tên CD", "Tên ca sỹ", "Số bài hát", "Giá thành");
                    for (int i = 0; i < n; i++) {
                        cd[i].hienThiAlbum();
                    }
                    break;
                case 3:
                    int tong = 0;
                    for (int i = 0; i < n; i++) {
                        tong += cd[i].getPrice();
                    }
                    System.out.println("" +
                            "Tổng giá thành là : " + tong);
                    break;
                case 4:
                    System.out.println("Tổng số lượng CD là : " + n);
                    break;
                case 5:
                    CD temp = cd[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (cd[i].getPrice()< cd[j].getPrice()) {
                                temp = cd[j];
                                cd[j] = cd[i];
                                cd[i] = temp;
                            }
                        }
                    }
                    break;
                case 6:
                    temp = cd[0];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (cd[i].getType().compareTo(cd[j].getType())>0) {
                                temp = cd[j];
                                cd[j] = cd[i];
                                cd[i] = temp;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Goodbye");
                    flag = false;
                    break;
            }
        }while (flag) ;
    }
    
}
