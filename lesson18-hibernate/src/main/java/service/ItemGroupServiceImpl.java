package service;

import dao.HibernateItemGroupDAO;
import dao.ItemGroupDao;
import persistence.ItemGroup;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService{

    private ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl() {
        itemGroupDao = new HibernateItemGroupDAO();
    }

    @Override
    public List<ItemGroup> getAll() {
        return itemGroupDao.getAll();
    }
}
