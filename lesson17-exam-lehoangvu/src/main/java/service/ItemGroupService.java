package service;

import java.sql.Date;
import java.util.List;

import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupAmount;


public class ItemGroupService {

	private ItemGroupDao itemGroupDao;

	public ItemGroupService() {
		itemGroupDao = new ItemGroupDao();
	}

	public List<ItemGroup> itemGroups(Date date) {
		return itemGroupDao.getItems(date);

	}

	public List<ItemGroupAmount> ItemGroupAmount() {
		return itemGroupDao.getItemsAmount();
	}
	public List<ItemGroupMost> itemGroupMost() {
		return itemGroupDao.Items();
	}
	
}