package ex02;


public class CD {
	private Integer id;
	private String 	type;
	private String 	singer;
	private Integer amount;
	private Double 	price;
	
	public CD() {
	}

	public CD(Integer id, String type, String singer, Integer amount, Double price) {
		super();
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.amount = amount;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof CD)) {
			return false;
		}
		CD that = (CD) obj;
		return this.getId() == that.getId();
	}

	
	@Override
	public String toString() {
		return "CD [id=" + id + ", type=" + type + ", singer=" + singer + ", amount=" + amount + ", price=" + price
				+ "]";
	}
	
	
}
