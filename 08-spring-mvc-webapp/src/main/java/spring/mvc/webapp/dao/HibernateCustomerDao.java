package spring.mvc.webapp.dao;

import java.util.List;

import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import common.Pageable;
import spring.mvc.webapp.entity.Customer;

@Repository
public class HibernateCustomerDao extends AbstractHibernateDao implements CustomerDao{
	
	private static final String PARAM_CUSTOMER_ID = "id";
	private static final String SQL_PARAM_CUSTOMER_ID = ":" + PARAM_CUSTOMER_ID;
	
	
	@Override
	public List<Customer> findAll() {
		return getCurrentSession()
				.createQuery("SELECT c FROM Customer c ORDER BY c.id DESC", Customer.class)
				.getResultList();
	}
	
	// HQL/JPQL does not support LIMIT native
	// --> setMaxResults
	// sortField --> entity attribute || table column(native)
	@Override
	public List<Customer> findAll(Pageable pageable, String sortField, String sortDir) {
		return getCurrentSession().createQuery(
				  "SELECT c FROM Customer c \n"
				+ "ORDER BY c." + sortField + " " + sortDir , Customer.class)
				.setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getRowCount())
				.getResultList();
	}
	
	@Override
	public int countTotalItems() {
		final String sql = "SELECT COUNT(*) AS totalRecords FROM customer";
		return (int) getCurrentSession().createNativeQuery(sql)
					  .addScalar("totalRecords", IntegerType.INSTANCE)
					  .getSingleResult();
	}
	
	@Override
	public void saveOrUpdate(Customer customer) {
		getCurrentSession().saveOrUpdate(customer);
	}
	
	@Override
	public Customer get(int id) {
		return getCurrentSession().get(Customer.class, id);
	}
	
	@Override
	public void delete(int id) {
		getCurrentSession().createQuery("DELETE FROM Customer WHERE id = " + SQL_PARAM_CUSTOMER_ID)
			.setParameter(PARAM_CUSTOMER_ID, id)
			.executeUpdate();
			
	}
}
