package bean;

public class Tuple {
	private int Max;
	private int Min;
	
	public Tuple() {
	}

	public int getMax() {
		return Max;
	}

	public void setMax(int max) {
		Max = max;
	}

	
	
	public Tuple(int max, int min) {
		super();
		Max = max;
		Min = min;
	}

	public int getMin() {
		return Min;
	}

	public void setMin(int min) {
		Min = min;
	}

	@Override
	public String toString() {
		return "MinMax [Max=" + Max + ", Min=" + Min + "]";
	}
	
	
	
}
