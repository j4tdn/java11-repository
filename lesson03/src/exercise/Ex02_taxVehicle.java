package exercise;

public class Ex02_taxVehicle {
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle("Nguyễn Thu Loan", "Future Neo", 100, 35000000);
		Vehicle v2 = new Vehicle("Lê Minh Tính", "Ford Ranger", 3000, 250000000);
		Vehicle v3 = new Vehicle("Nguyễn Minh Triết", "Landscape", 1500, 1000000000);
		System.out.printf("%-25s %-25s %10s %25s %25s\n","Tên chủ xe","Loại xe","Dung tích","Trị giá","Thuế");
		System.out.println("=====================================================================================================================");
		
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
	}

}
