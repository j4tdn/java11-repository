package persistence;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitietmathang")
public class ItemDetail  {

    @EmbeddedId
    private Id id;

    @Column(name = "hinhanh")
    private String image;
    @Column(name = "giaban")
    private Double salesPrice;
    @Column(name = "giamua")
    private Double originPrice;
    @Column(name = "soluong")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mamh",referencedColumnName = "mamh",insertable = false,updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="makc",referencedColumnName = "makc",insertable = false,updatable = false)
    private Size size;

    public ItemDetail(){}

    @Override
    public String toString() {
        return "ItemDetail{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", salesPrice=" + salesPrice +
                ", originPrice=" + originPrice +
                ", amount=" + amount +
                '}';
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = -7774813629925126938L;

        @Column(name = "mamh")
        private Integer itemId;
        @Column(name="makc")
        private String  sizeId;

        public Id(){}

        public Id(Integer itemId, String sizeId) {
            this.itemId = itemId;
            this.sizeId = sizeId;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public String getSizeId() {
            return sizeId;
        }

        public void setSizeId(String sizeId) {
            this.sizeId = sizeId;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "itemId=" + itemId +
                    ", sizeId='" + sizeId + '\'' +
                    '}';
        }
    }
}
