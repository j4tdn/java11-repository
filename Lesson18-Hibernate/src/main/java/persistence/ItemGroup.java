package persistence;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaihang")
@NamedQueries({
        @NamedQuery(name =ItemGroup.Q_GET_ALL,query = "from ItemGroup")
})
public class ItemGroup {

    public final static String Q_GET_ALL = "Q_GET_ALL";

    @Id
    @Column(name = "malh")
    private Integer id;
    @Column(name = "tenlh", nullable = false)
    private String name;

    @OneToMany(mappedBy = "itemGroup")
    private List<Item> items;

    public ItemGroup() {

    }

    public ItemGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
}
