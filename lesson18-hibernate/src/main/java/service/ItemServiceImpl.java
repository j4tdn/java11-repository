package service;

import dao.HibernateItemDao;
import dao.ItemDao;
import persistence.Item;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    public ItemServiceImpl() {
        itemDao = new HibernateItemDao();
    }

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }

}
