package bt02;

import java.util.Objects;

public class CD {
	private int maCD;
	private String type;
	private String singer;
	private int amount;
	private float price;

	public CD() {

	}

	public CD(int maCD, String type, String singer, int amount, float price) {
		this.maCD = maCD;
		this.type = type;
		this.singer = singer;
		this.amount = amount;
		this.price = price;
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CD)) {
			return false;
		}

		CD that = (CD) obj;

		return getMaCD() == that.getMaCD();

	}

	@Override
	public int hashCode() {
		return Objects.hash(maCD);
	}

	@Override
	public String toString() {
		return "CD [maCD=" + maCD + ", type=" + type + ", singer=" + singer + ", amount=" + amount + ", price=" + price
				+ "]";
	}

}
