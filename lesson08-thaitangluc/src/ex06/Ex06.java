package ex06;

import java.util.Scanner;

public class Ex06 {
	public static int solve(int k) {
		if (k >= 1 && k <= 9)
			return k;
		int sum = 9;
		int curLen = 1;
		int base = 1;
		while (sum < k) {
			++curLen;
			base *= 10;
			int add = 9 * base;
			sum += add * curLen;
		}
		int curInterval = 9 * base;
		int prevInterval = sum - curInterval * curLen;
		int low = base, high = 10 * base - 1;
		int num = -1;
		int startNumber = base;
		while (low <= high) {
			int mid = (low + high) >> 1;
			int distance = (mid - startNumber + 1) * curLen + prevInterval;
			if (distance >= k) {
				num = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		int pos = (k - prevInterval) % curLen;
		--pos;
		if (pos < 0)
			pos += curLen;
		return Integer.toString(num).charAt(pos) - '0';
	}

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		int k = r.nextInt();
		System.out.println(solve(k));
	}

}
