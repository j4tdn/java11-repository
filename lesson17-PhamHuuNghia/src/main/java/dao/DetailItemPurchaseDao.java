package dao;

import java.util.List;

import persistence.DetailItemPurchaseDto;

public interface DetailItemPurchaseDao {
	public List<DetailItemPurchaseDto> get(int year);
}
