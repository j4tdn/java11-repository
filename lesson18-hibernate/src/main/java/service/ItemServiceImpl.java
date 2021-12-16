package service;

<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
import java.util.List;

import dao.HibernateItemDao;
import dao.ItemDao;
<<<<<<< HEAD
import dao.ItemDaoImpl;
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	private static ItemDao itemDao;
=======
import persistence.Item;

public class ItemServiceImpl implements ItemService{
	
	private ItemDao itemDao;
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
	
	public ItemServiceImpl() {
		itemDao = new HibernateItemDao();
	}
	
<<<<<<< HEAD
	@Override
	public List<Item> get(String name) {
		return itemDao.get(name);
	}
	
	@Override
	public List<Item> get(LocalDate orderDate) {
		return itemDao.get(orderDate);
	}

=======
	public List<Item> getAll() {
		return itemDao.getAll();
	}
>>>>>>> 2651c26d (lesson18 - Hibernate 14.12.2021)
}