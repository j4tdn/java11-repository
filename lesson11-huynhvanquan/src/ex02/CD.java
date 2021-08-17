package ex02;

public class CD {
	int id;
	String category;
	String singer;
	int songNumber;
	double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getSongNumber() {
		return songNumber;
	}
	public void setSongNumber(int songNumber) {
		this.songNumber = songNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CD(int id, String category, String singer, int songNumber, double price) {
		super();
		this.id = id;
		this.category = category;
		this.singer = singer;
		this.songNumber = songNumber;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CD [id=" + id + ", category=" + category + ", singer=" + singer + ", songNumber=" + songNumber
				+ ", price=" + price + "]";
	}
	
	
}
