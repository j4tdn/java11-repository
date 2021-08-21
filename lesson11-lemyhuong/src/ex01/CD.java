package ex01;

public class CD {
	private int id;
	private String type;
	private String singer;
	private int noOfSongs;
	private double price;
	
	public CD() {
	}

	public CD(int id, String type, String singer, int noOfSongs, double price) {
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.noOfSongs = noOfSongs;
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

	public int getNoOfSongs() {
		return noOfSongs;
	}

	public void setNoOfSongs(int noOfSongs) {
		this.noOfSongs = noOfSongs;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", type=" + type + ", singer=" + singer + ", noOfSongs=" + noOfSongs + ", price="
				+ price + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		
		if (!(o instanceof CD)) {
			return false;
		}
		
		CD that = (CD)o;
		
		return getId() == that.getId();
	}
	
	
}
