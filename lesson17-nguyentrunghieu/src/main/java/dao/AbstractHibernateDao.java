package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import utils.HibernateUtil;

public class AbstractHibernateDao {
	Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}