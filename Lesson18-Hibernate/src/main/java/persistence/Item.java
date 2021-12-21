package persistence;


import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Fetch;

@Entity
@Table(name = "mathang")
public class Item {
    @Id
    @Column(name = "mamh")
    private Integer id;
    @Column(name = "tenmh")
    private String name;
    @Column(name = "mausac")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "malh", referencedColumnName = "malh")
    private ItemGroup itemGroup;

    public Item() {

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
                ", itemGroup=" +
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
