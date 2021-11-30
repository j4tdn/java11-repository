package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;
import persistence.ItemsDto;

public interface ItemGroupDao {
	List<ItemGroupDto> getAmountItemGroup();
	List<ItemsDto> getAllItemById();
}
