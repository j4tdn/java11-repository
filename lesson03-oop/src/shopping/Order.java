
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
public class Order {
    private Customer customer;
    private ItemDetail[] itemDetails;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(Customer customer, ItemDetail[] itemDetails, LocalDateTime orderDate) {
        this.customer = customer;
        this.itemDetails = itemDetails;
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemDetail[] getItemDetails() {
        return this.itemDetails;
    }

    public void setItemDetails(ItemDetail[] itemDetails) {
        this.itemDetails = itemDetails;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "{" +
            " customer='" + getCustomer() + "'" +
            ", itemDetails='" + getItemDetails() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            "}";
    }
   
    
}
