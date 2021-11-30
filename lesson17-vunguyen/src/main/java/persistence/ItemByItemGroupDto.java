package persistence;

public class ItemByItemGroupDto {
    private Integer id;
    private String name;
    private ItemGroup itemGroup;
    private Integer salePrice;
    private Integer purchasePrice;
    private Integer numOfItems;
    private String size;

    public ItemByItemGroupDto() {
    }

    public ItemByItemGroupDto(Integer id,
                              String name,
                              ItemGroup itemGroup,
                              Integer salePrice,
                              Integer purchasePrice, Integer numOfItems, String size) {
        this.id = id;
        this.name = name;
        this.itemGroup = itemGroup;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.numOfItems = numOfItems;
        this.size = size;
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

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(Integer numOfItems) {
        this.numOfItems = numOfItems;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ItemByItemGroupDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", itemGroup=" + itemGroup +
               ", salePrice=" + salePrice +
               ", purchasePrice=" + purchasePrice +
               ", numOfItems=" + numOfItems +
               ", size='" + size + '\'' +
               '}';
    }
}
