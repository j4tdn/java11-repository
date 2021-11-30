package service;

import java.util.List;

import dao.ItemDetailDao;
import dao.ItemDetailDaoImpl;
import persistence.ItemDetailDto;

public class ItemDetailServiceImpl implements ItemDetailService{
	private ItemDetailDao itemDetailDao;
	
	public ItemDetailServiceImpl() {
		itemDetailDao = new ItemDetailDaoImpl();
	}
	
	@Override
	public List<ItemDetailDto> getInventory() {
		return itemDetailDao.getInventory();
	}

}
