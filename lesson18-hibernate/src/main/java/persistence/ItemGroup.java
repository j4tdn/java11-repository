package persistence;

// Mapped with LoạiHang table
// Entity: Java Class used for mapping properties with table columns
// >> Get from Table >> Table's columns automatically set into corresponding Class's properties

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LoaiHang")
@NamedQueries({
        @NamedQuery(name = ItemGroup.Q_GET_ALL, query = "FROM ItemGroup")
})
public class ItemGroup {

    public static final String Q_GET_ALL = "Q_GET_ALL";

    @Id
    @Column(name = "MaLH")
    private Integer id;

    @Column(name = "TenLH")
    private String name;

    // Mapping 1-N with Item
    @OneToMany(mappedBy = "itemGroup")
    private List<Item> items;

    // fetch type
    // @OneToMany: LAZY FETCH

    /**
     * Hibernate Empty Constructor
     */
    public ItemGroup() {
    }

    public ItemGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
