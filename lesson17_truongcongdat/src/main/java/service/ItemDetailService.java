package service;

import java.util.List;

import persistence.ItemDetailDto;

public interface ItemDetailService {
	List<ItemDetailDto> getInventory();
}
