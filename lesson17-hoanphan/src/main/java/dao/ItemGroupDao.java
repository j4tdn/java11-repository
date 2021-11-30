
package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.ItemGroupDto;

public interface ItemGroupDao {
	
	List<ItemGroupDto> getItems();
	

}