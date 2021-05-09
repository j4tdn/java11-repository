
public class Item {
    private String id;
    private String os;
    private String color;
    private double cost;  //database: column: null, non-null: extra-info: text

    public Item() {
    }

    public Item(String id, String os, String color, double cost) {
        this.id = id;
        this.os = os;
        this.color = color;
        this.cost = cost;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", os='" + getOs() + "'" +
            ", color='" + getColor() + "'" +
            ", cost='" + getCost() + "'" +
            "}";
    }

}
