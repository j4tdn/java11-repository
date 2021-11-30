package service;

import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;
import dao.ItemGroupDao;
import dao.ItemGroupDaoImpl;
import dto.DetailsItems;

public class ItemGroupServiceImpl implements ItemGroupService{
private static ItemGroupDao itemgroupDao;
	
	public ItemGroupServiceImpl() {
		itemgroupDao = new ItemGroupDaoImpl();
	}

	public List<DetailsItems> getItemsByGroupItem() {
		return itemgroupDao.getItemsByItemGroup();
	}

}
