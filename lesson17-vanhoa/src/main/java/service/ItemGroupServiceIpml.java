package service;

import java.util.List;

import dao.ItemGroupDao;
import dao.ItemGroupDaoIpml;
import persistence.ItemGroupDto;

public class ItemGroupServiceIpml implements ItemGroupService {
	private static ItemGroupDao itemGroupDao;

	public ItemGroupServiceIpml() {
		itemGroupDao = new ItemGroupDaoIpml();
	}

	@Override
	public List<ItemGroupDto> getWithNumberOf() {
		return itemGroupDao.getWithNumberOf();
	}
}
