package service;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService {

    private ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl()
    {
        itemGroupDao = new HibernateItemGroupDao();
    }

    @Override
    public List<ItemGroup> getAll() {
        return itemGroupDao.getAll();
    }
}
