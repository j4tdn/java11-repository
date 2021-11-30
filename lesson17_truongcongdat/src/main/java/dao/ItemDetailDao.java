package dao;

import java.util.List;

import persistence.ItemDetailDto;

public interface ItemDetailDao {
	List<ItemDetailDto> getInventory();
}
