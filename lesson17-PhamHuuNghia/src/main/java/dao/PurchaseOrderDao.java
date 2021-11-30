package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.PurchaseOrderDto;

public interface PurchaseOrderDao {
	public List<PurchaseOrderDto> get(LocalDate date);
}
