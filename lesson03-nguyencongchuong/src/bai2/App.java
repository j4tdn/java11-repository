package bai2;

public class App {
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(123, "AB", 110, 3500);
		Vehicle v2 = new Vehicle(124, "Exciter", 150, 5200);
		Vehicle v3 = new Vehicle(125, "Cub", 50, 1700);
		Vehicle v4 = new Vehicle(126, "Kawasaki", 1000, 4500);

		Owner o1 = new Owner(111, "Nguyễn Công Chương", "123 Nguyễn Huy Tưởng");
		Owner o2 = new Owner(112, "Trần Quốc Hưng", "123 Nguyễn Huy Tưởng");
		Owner o3 = new Owner(113, "Đặng Văn hải", "123 Nguyễn Huy Tưởng");
		Owner o4 = new Owner(114, "Trần Văn Dũng", "123 Nguyễn Huy Tưởng");

		TaxManager t1 = new TaxManager(v1, o3);
		TaxManager t2 = new TaxManager(v2, o1);
		TaxManager t3 = new TaxManager(v3, o4);
		TaxManager t4 = new TaxManager(v4, o2);

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá",
				"Thuế phải nộp");
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", t1.getOwner().getName(), t1.getVehicle().getModel(),
				t1.getVehicle().getCapacity(), t1.getVehicle().getCost(), TaxUtil.exportTax(t1));

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", t2.getOwner().getName(), t2.getVehicle().getModel(),
				t2.getVehicle().getCapacity(), t2.getVehicle().getCost(), TaxUtil.exportTax(t2));

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", t3.getOwner().getName(), t3.getVehicle().getModel(),
				t3.getVehicle().getCapacity(), t3.getVehicle().getCost(), TaxUtil.exportTax(t3));

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", t4.getOwner().getName(), t4.getVehicle().getModel(),
				t4.getVehicle().getCapacity(), t4.getVehicle().getCost(), TaxUtil.exportTax(t4));
	}
}
