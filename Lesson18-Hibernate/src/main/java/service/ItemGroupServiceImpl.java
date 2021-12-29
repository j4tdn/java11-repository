package service;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

import java.util.List;

public class ItemGroupServiceImpl implements ItemGroupService {

    private final ItemGroupDao itemGroupDao;

    public ItemGroupServiceImpl()
    {
        itemGroupDao = new HibernateItemGroupDao();
    }

    @Override
    public List<ItemGroup> getAll() {
        return itemGroupDao.getAll();
    }

    @Override
    public List<ItemGroupDto> getItemByItemGroupId() {
        return itemGroupDao.getItemByItemGroupId();
    }

    @Override
    public void demoSlvCache() {
        itemGroupDao.demoSlvCache();
    }
}
