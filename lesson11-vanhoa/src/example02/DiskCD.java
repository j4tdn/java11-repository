package example02;

public class DiskCD {
	private int id;
	private String type;
	private String singer;
	private int amount;
	private double price;

	public DiskCD() {
	}

	public DiskCD(int id, String type, String singer, int amount, double price) {
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", type=" + type + ", singer=" + singer + ", amount=" + amount + ", price=" + price
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if(!(obj instanceof DiskCD)) {
			return false;
		}
		
		DiskCD that = (DiskCD)obj;
		return this.getId() == that.getId() ;
	}

}
