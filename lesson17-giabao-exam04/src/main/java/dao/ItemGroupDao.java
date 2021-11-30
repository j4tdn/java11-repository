package dao;

import java.util.List;

import dto.DetailsItems;
import persistence.ItemGroup;

public interface ItemGroupDao {
	List<DetailsItems> getItemsByItemGroup();
}
