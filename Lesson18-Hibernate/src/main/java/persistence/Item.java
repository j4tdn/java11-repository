package persistence;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mathang")

@NamedQueries({
        @NamedQuery(name = Item.Q_GET_ITEM,query = "from Item where id =:id")
})
public class Item {
    public final static String Q_GET_ITEM = "Q_GET_ITEM";

    @Id
    @Column(name = "mamh")
    private Integer id;
    @Column(name = "tenmh")
    private String name;
    @Column(name = "mausac")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "malh", referencedColumnName = "malh",insertable = false,updatable = false)
    private ItemGroup itemGroup;

    @OneToMany(mappedBy = "item")
    List<ItemDetail> itemDetails;

    public Item() {

    }
    public List<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }




    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", itemGroup=" + itemGroup +
                ", itemDetails=" + itemDetails +
                '}';
    }

    public Item(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
