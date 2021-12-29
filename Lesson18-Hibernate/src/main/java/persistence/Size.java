package persistence;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kichco")
public class Size {
    @Id
    @Column(name = "MaKC")
    private String id;
    @Column(name = "MoTa")
    private String desc;

    @OneToMany(mappedBy = "size")
    private List<ItemDetail> itemDetails;

    public Size(){}

    public Size(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public List<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
