package persistence;

// Mapped with LoạiHang table
// Entity: Java Class used for mapping properties with table columns
// >> Get from Table >> Table's columns automatically set into corresponding Class's properties

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiHang")
public class ItemGroup {

    @Id
    @Column(name = "MaLH")
    private Integer id;

    @Column(name = "TenLH")
    private String name;

    // Mapping 1-N with Item
    // private List<Item> items;

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

    @Override
    public String toString() {
        return "ItemGroup{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
