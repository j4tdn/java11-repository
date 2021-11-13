package allocation;

import java.math.BigDecimal;
import java.util.Objects;

public class Store {

    private Long storeId;
    private Long referenceStoreId;
    private BigDecimal stockPreviousDay;
    private BigDecimal expectedSales;
    private Boolean isSelected;

    public Store() {

    }

    public Store(final Long storeId, final Long referenceStoreId, final BigDecimal stockPreviousDay, final BigDecimal expectedSales, final Boolean isSelected) {
        this.storeId = storeId;
        this.referenceStoreId = referenceStoreId;
        this.stockPreviousDay = stockPreviousDay;
        this.expectedSales = expectedSales;
        this.isSelected = isSelected;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(final Long storeId) {
        this.storeId = storeId;
    }

    public Long getReferenceStoreId() {
        return referenceStoreId;
    }

    public void setReferenceStoreId(final Long referenceStoreId) {
        this.referenceStoreId = referenceStoreId;
    }

    public BigDecimal getStockPreviousDay() {
        return stockPreviousDay;
    }

    public void setStorePreviousDay(final BigDecimal stockPreviousDay) {
        this.stockPreviousDay = stockPreviousDay;
    }

    public BigDecimal getExpectedSales() {
        return expectedSales;
    }

    public void setExpectedSales(final BigDecimal expectedSales) {
        this.expectedSales = expectedSales;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(final Boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
        	return true;
        }

        if (!(o instanceof Store)) {
        	return false;
        }

        final Store that = (Store) o;

        return getStoreId().equals(that.getStoreId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId());
    }

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", referenceStoreId=" + referenceStoreId + ", stockPreviousDay="
				+ stockPreviousDay + ", expectedSales=" + expectedSales + ", isSelected=" + isSelected + "]";
	}
}