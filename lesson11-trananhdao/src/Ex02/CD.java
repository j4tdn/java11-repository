package Ex02;

public class CD {
	private int id;
    private String type;
    private String single;
    private int numberOfSong;
    private double price;

    public CD() {
    }

    public CD(int id, String type, String single, int numberOfSong, double price) {
        this.id = id;
        this.type = type;
        this.single = single;
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

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
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
        return "CD{" + "id=" + id + ", type=" + type + ", single=" + single + ", numberOfSong=" + numberOfSong + ", price=" + price + '}';
    }
    
    public void hienThiAlbum(){
        System.out.printf("%-10d %-20s %-20s %-10d %-20.1f \n",id,type,single,numberOfSong,price);
    }
    
}
