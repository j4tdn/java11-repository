package dao;

import java.util.List;
import persistencce.ItemGroup;

public interface ItemGroupDao {
	List<ItemGroup> getAll();
	
	ItemGroup get(int id);

}