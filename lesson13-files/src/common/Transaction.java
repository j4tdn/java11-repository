package common;

public class Transaction implements FileHandler{
	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}
	@Override
	public String toLine() {
		return "[" + trader.getCity() + ", " + trader.getName() + "]" + "-" + getYear() + "-" + getValue();
	}

	public String toString() {
		return "{" + this.trader + ", " +
				"year: " + this.year + ", " +
				"value:" + this.value + "}";
	}

	@Override
	public Object toOject() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}