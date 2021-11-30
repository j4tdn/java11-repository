package persistence;

import java.time.LocalDate;

public class ItemByDateDto {
    private Integer id;
    private String name;
    private LocalDate orderDate;

    public ItemByDateDto() {
    }

    public ItemByDateDto(Integer id, String name, LocalDate orderDate) {
        this.id = id;
        this.name = name;
        this.orderDate = orderDate;
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", orderDate=" + orderDate +
               '}';
    }
}
