package service;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService{
	private ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		// TODO Auto-generated constructor stub
		itemGroupDao=new HibernateItemGroupDao();
	}
	public List<ItemGroup>getAll(){
		return itemGroupDao.getAll();
	}
	public List<ItemGroupDto> getItemsByItemGroupId() {
		// TODO Auto-generated method stub
		return itemGroupDao.getItemsByItemGroupId();
	}
	public void demoSlvCache() {
		itemGroupDao.demoSlvCache();
	}
	
}
