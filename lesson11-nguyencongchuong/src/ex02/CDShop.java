package ex02;

import java.awt.event.ItemEvent;

public class CDShop {
	private int id;
	private String type;
	private String singer;
	private int songNumber;
	private double price;
	
	public CDShop() {
	}

	public CDShop(int id, String type, String singer, int songNumber, double price) {
		super();
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.songNumber = songNumber;
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
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof CDShop)) {
			return false;
		}
		CDShop that = (CDShop)o;
		return getPrice() == that.getPrice() && getType() == that.getType();
	}

	@Override
	public String toString() {
		return "CDShop [id=" + id + ", type=" + type + ", singer=" + singer + ", songNumber=" + songNumber + ", price="
				+ price + "]";
	}
	
	
}
