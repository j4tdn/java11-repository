package bai4;

import java.util.Scanner;

public class PeopleFactory {
	enum PeopleType {
		GIAMDOC, TRUONGPHONG, NHANVIEN
	}

	private PeopleFactory() {
	}

	public static People getPeople(PeopleType type) {
		People people = null;

		switch (type) {
		case GIAMDOC:
			people = createGiamDoc();
			break;
		case TRUONGPHONG:
			people = createTruongPhong();
			break;
		case NHANVIEN:
			people = createNhanVien();
			break;

		default:
			people = new People() {
				
				@Override
				void input() {
					Scanner ip = new Scanner(System.in);
					System.out.print("Nhập tên: ");
					setName(ip.nextLine());
					System.out.print("Nhập id: ");
					setId(ip.nextInt());
					System.out.print("Nhập hệ số lương: ");
					setHsl(ip.nextFloat());
					System.out.print("Nhập hệ số chức vụ: ");
					setHscv(ip.nextFloat());
				}
				
				@Override
				double Luong() {
					return 0;
				}
			};
		}

		return people;
	}

	private static GiamDoc createGiamDoc() {
		return new GiamDoc();
	}

	private static TruongPhong createTruongPhong() {
		return new TruongPhong();
	}

	private static NhanVien createNhanVien() {
		return new NhanVien();
	}
}
