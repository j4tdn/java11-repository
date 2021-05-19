package bai1;

public class Avg {
	
	private Avg() {
	}
	
	public static float export(SinhVien sv) {
		float score = 0;

		score = (sv.getLH() + sv.getTH()) / 2;

		return score;
	}
}
