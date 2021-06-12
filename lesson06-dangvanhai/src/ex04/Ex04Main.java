package ex04;

public class Ex04Main {
	public static void main(String[] args) {
		System.out.println(readNumer(0));
		System.out.println(readNumer(1));
		System.out.println(readNumer(5));
		System.out.println(readNumer(6));
		System.out.println(readNumer(16));
		System.out.println(readNumer(21));
		System.out.println(readNumer(25));
		System.out.println(readNumer(34));
		System.out.println(readNumer(55));
		System.out.println(readNumer(100));
		System.out.println(readNumer(101));
		System.out.println(readNumer(105));
		System.out.println(readNumer(135));
		System.out.println(readNumer(152));
		System.out.println(readNumer(171));
		System.out.println(readNumer(213));
		System.out.println(readNumer(219));
		System.out.println(readNumer(321));
		System.out.println(readNumer(400));
		System.out.println(readNumer(414));
		System.out.println(readNumer(433));
		System.out.println(readNumer(500));
		System.out.println(readNumer(513));
		System.out.println(readNumer(710));
		System.out.println(readNumer(999));
	}

	private static int[] split(int n) {
		int[] arr = { n / 100, (n % 100) / 10, n % 10 };
		return arr;
	}

	private static String readNumer(int n) {
		// Validation
		if (n > 999)
			return "Exceeding";

		// Split the number
		int[] c = split(n);

		// Print n
		System.out.print(n + " : ");

		// Solve
		String result = "";
		String[] arr = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười" };
		if (c[0] > 0) {
			result = arr[c[0]] + " trăm ";
			arr[0] = "";
		}
		if (c[1] > 1) {
			result = result + arr[c[1]] + " muơi ";
		} else if (c[1] == 1) {
			result += "mười ";
		} else if (c[2] > 0 && c[0] > 0) {
			result += "lẻ ";
		}
		if ((c[0] > 0 || c[1] > 0) && c[1] != 0) {
			arr[1] = "mốt";
			arr[5] = "lăm";
		}
		result += arr[c[2]];

		// Format result String
		result = result.substring(0, 1).toUpperCase() + result.substring(1);
		return result;
	}

}
