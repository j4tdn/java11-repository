package ex02;

import java.util.Objects;

public class CDStore implements Comparable<CDStore> {
	private int Id;
	private String type;
	private String singer;
	private int mountOfSongs;
	private int price;
	
	public CDStore() {
		
	}

	public CDStore(int id, String type, String singer, int mountOfSongs, int price) {
		super();
		Id = id;
		this.type = type;
		this.singer = singer;
		this.mountOfSongs = mountOfSongs;
		this.price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public int getMountOfSongs() {
		return mountOfSongs;
	}

	public void setMountOfSongs(int mountOfSongs) {
		this.mountOfSongs = mountOfSongs;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object o) {
		Objects.requireNonNull(o);
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof CDStore)) {
			return false;
		}
		
		CDStore that = (CDStore)o;
		return getId() == that.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	
	

	@Override
	public String toString() {
		return "CDStore [Id=" + Id + ", type=" + type + ", singer=" + singer + ", mountOfSongs=" + mountOfSongs
				+ ", price=" + price + "]";
	}

	@Override
	public int compareTo(CDStore o) {
		return this.getId() - o.getId();
	}
}
