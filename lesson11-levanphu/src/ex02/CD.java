package ex02;

public class CD {
	private int id;
    private String type;
    private String singer;
    private int numberOfSong;
    private double price;

    public CD() {
    }

    public CD(int id, String type, String singer, int numberOfSong, double price) {
        this.id = id;
        this.type = type;
        this.singer = singer;
        this.numberOfSong = numberOfSong;
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

    public int getNumberOfSong() {
        return numberOfSong;
    }

    public void setNumberOfSong(int numberOfSong) {
        this.numberOfSong = numberOfSong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "CD{" + "id=" + id + ", type=" + type + ", singer=" + singer + ", numberOfSong=" + numberOfSong + ", price=" + price + '}';
    }
}
