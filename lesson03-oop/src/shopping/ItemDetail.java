
public class ItemDetail {
    private Item item;
    private int quantity;

    public ItemDetail() {
    }

    public ItemDetail(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " item='" + getItem() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }
    
}
