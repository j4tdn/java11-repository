package bai05;

import java.util.ArrayList;

public class App {
   static ArrayList<Sach> a = new ArrayList();
   
   public static void main(String[] args) {
	SGK gk1 = new SGK("SGK01",30,"Nhi Dong","Sach moi");
	SGK gk2 = new SGK("SGK02",120,"Thieu Nien","Sach cu");
	SGK gk3 = new SGK("SGK03",20,"Nhi Dong","Sach moi");
	
	SachThamKhao tk1 = new SachThamKhao("STK01",150,"Nhi Dong",0.5);
	SachThamKhao tk2 = new SachThamKhao("STK02",110,"Bo Giao Duc",0.7);
	
	a.add(gk1);
	a.add(gk2);
	a.add(gk3);
	a.add(tk1);
	a.add(tk2);
	System.out.println("=========================");
	System.out.println("Sach thuoc NXB Nhi Dong");
	timTheoNXB("Nhi Dong");
	System.out.println("\nSach co don gia nho hon 50");
	timTheoGia();
	System.out.println("\nToan bo SGK co don gia tu 100 den 200");
	timGiaTheoSGK();
}
   
   public static void timTheoNXB(String NXB) {
	   for(Sach x : a) {
		   if(x.getNhaXB().equalsIgnoreCase(NXB)) {
			   System.out.println(x);
		   }
	   }
   }
   
   public static void timTheoGia() {
	   for ( Sach x : a) {
		   if(x.getDonGia()<50) {
			   System.out.println(x);
		   }
	   }
   }
   
   public static void timGiaTheoSGK() {
	   for(Sach x : a) {
		   if(x instanceof SGK ) {
			   if(x.getDonGia()>100 && x.getDonGia()<200) {
				   System.out.println(x);
			   }
		   }
	   }
   }
   
   public static Sach themMoi(Sach x) {
	   a.add(x);
	return x;
   }
}
