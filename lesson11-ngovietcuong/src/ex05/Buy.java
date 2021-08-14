package ex05;

//	Amount kilograms bought for each type
public class Buy {
	private int meat;
	private int fish;
	private int vegetable;
	private int fruit;

	public Buy() {
	}

	public Buy(int meat, int fish, int vegetable, int fruit) {
		this.meat = meat;
		this.fish = fish;
		this.vegetable = vegetable;
		this.fruit = fruit;
	}

	public int getMeat() {
		return meat;
	}

	public void setMeat(int meat) {
		this.meat = meat;
	}

	public int getFish() {
		return fish;
	}

	public void setFish(int fish) {
		this.fish = fish;
	}

	public int getVegetable() {
		return vegetable;
	}

	public void setVegetable(int vegetable) {
		this.vegetable = vegetable;
	}

	public int getFruit() {
		return fruit;
	}

	public void setFruit(int fruit) {
		this.fruit = fruit;
	}
	
	@Override
	public String toString() {
		return "Buy (" + meat + ", " + fish + ", " + vegetable + ", " + fruit + ")";
	}
}
