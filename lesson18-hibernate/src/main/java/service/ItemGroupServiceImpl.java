package service;

<<<<<<< HEAD
import dao.ItemGroupDao;
=======
import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private ItemGroupDao itemGroupDao;
	
<<<<<<< HEAD
	public ItemGroup
=======
	public ItemGroupServiceImpl() {
		itemGroupDao = new HibernateItemGroupDao();
	}
	
	public List<ItemGroup> getAll(){
		return itemGroupDao.getAll();
	}
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
}
