package ex05;

// Total money bought for each type
public class Money {
	private int priceMeat;
	private int priceFish;
	private int priceVegetable;
	private int priceFruit;

	public Money() {
	}

	public Money(int priceMeat, int priceFish, int priceVegetable, int priceFruit) {
		this.priceMeat = priceMeat;
		this.priceFish = priceFish;
		this.priceVegetable = priceVegetable;
		this.priceFruit = priceFruit;
	}

	public int getPriceMeat() {
		return priceMeat;
	}

	public void setPriceMeat(int priceMeat) {
		this.priceMeat = priceMeat;
	}

	public int getPriceFish() {
		return priceFish;
	}

	public void setPriceFish(int priceFish) {
		this.priceFish = priceFish;
	}

	public int getPriceVegetable() {
		return priceVegetable;
	}

	public void setPriceVegetable(int priceVegetable) {
		this.priceVegetable = priceVegetable;
	}

	public int getPriceFruit() {
		return priceFruit;
	}

	public void setPriceFruit(int priceFruit) {
		this.priceFruit = priceFruit;
	}

	@Override
	public String toString() {
		return "Money (" + priceMeat + ", " + priceFish + ", " + priceVegetable + ", " + priceFruit + ")";
	}
}
