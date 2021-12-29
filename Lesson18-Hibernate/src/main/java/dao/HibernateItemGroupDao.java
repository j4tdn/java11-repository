package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import persistence.ItemGroup;
import persistence.ItemGroupDto;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HibernateItemGroupDao extends AbstactHibernateDao implements ItemGroupDao {

    private static final String Q_GET_ITEMS_BY_ITEM_GROUP_ID =
                    "select  l.malh as " + ItemGroupDto.ITEM_GROUP_ID
                    + ",l.tenlh as " + ItemGroupDto.ITEM_GROUP_NAME + ",sum(ct.soluong) as " + ItemGroupDto.NUMBERS_ID
                    + " from mathang as m inner join loaihang as l on m.malh = l.malh inner " +
                    "join chitietmathang as ct on m.mamh = ct.mamh group by l.malh";


    @Override
    public void demoSlvCache() {
        Session session1 = openSession();
        Session session2 = openSession();
        System.out.println("khoa");


        ItemGroup item1 = session1.get(ItemGroup.class,2);


        sleep(4L);
        ItemGroup item3 = session2.get(ItemGroup.class,2);
        System.out.println(item1);
        System.out.println(item3);



    }

    private static void sleep(long seconds)
    {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ItemGroup> getAll() {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        Query<ItemGroup> query = null;
        try {
            //query = session.createNativeQuery(Q_GET_ALL, ItemGroup.class);
            query = session.createNamedQuery(ItemGroup.Q_GET_ALL, ItemGroup.class);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<ItemGroupDto> getItemByItemGroupId() {
        Session session = openSession();
        return session.createNativeQuery(Q_GET_ITEMS_BY_ITEM_GROUP_ID)
                .addScalar(ItemGroupDto.ITEM_GROUP_ID, IntegerType.INSTANCE)
                .addScalar(ItemGroupDto.ITEM_GROUP_NAME, StringType.INSTANCE)
                .addScalar(ItemGroupDto.NUMBERS_ID, IntegerType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))
                .getResultList();
    }
}
