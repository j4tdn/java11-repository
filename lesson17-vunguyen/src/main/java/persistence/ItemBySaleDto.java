package persistence;

public class ItemBySaleDto {
    private Integer id;
    private String name;
    private Integer saleNumber;

    public ItemBySaleDto() {
    }

    public ItemBySaleDto(Integer id, String name, Integer saleNumber) {
        this.id = id;
        this.name = name;
        this.saleNumber = saleNumber;
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

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    @Override
    public String toString() {
        return "ItemBySaleDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", saleNumber=" + saleNumber +
               '}';
    }
}
