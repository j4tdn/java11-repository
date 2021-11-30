package dao;

import java.util.List;

import persistence.ItemGroupDto;

public interface ItemGroupDao {
	List<ItemGroupDto> getItemsByItemGroupId();

}
