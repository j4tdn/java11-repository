package service;

import java.util.List;

import persistence.DetaiItemGroupDto;
import persistence.DetailItemPurchaseDto;

public interface DetailItemPurchaseService {
	public List<DetailItemPurchaseDto> get(int year);
}
