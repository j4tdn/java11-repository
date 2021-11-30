package service;

import java.time.LocalDate;
import java.util.List;

import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {

	private ItemGroupDao itemGroupDao;

	@Override
	public List<ItemGroup> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemGroup get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemGroup> get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemGroupDto> getItemGroupbyDateDelivery(LocalDate dateDelivery) {
		return itemGroupDao.get(dateDelivery);
	}

	@Override
	public List<ItemGroupDto> getItemGroupbyGroupId() {
		return itemGroupDao.getItemsByItemGroupId();
	}
}
