package common;

import java.io.Serializable;

public class Transaction implements FileHandler, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Trader trader;
	private int year;
	private int value;
	
	public Transaction(String line) {
		String[] transacItems = line.split("\\s-\\s");
		String tmp = transacItems[0].substring(1, transacItems[0].length() - 1);
		String[] traderItems = tmp.split(",\\s");
		if (traderItems.length == 2 && transacItems.length == 3) {
			trader = new Trader(traderItems[0], traderItems[1]);
			year = Integer.parseInt(transacItems[1]);
			value = Integer.parseInt(transacItems[2]);
		}
	}
	
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
		return "[" + trader.getCity() + ", " + trader.getName() + "]" + " - " + getYear() + " - " + getValue();
	}
	
	public String toString() {
		return "{" + this.trader + ", " +
				"year: " + this.year + ", " +
				"value: " + this.value + "}";
	}
}