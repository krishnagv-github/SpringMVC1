package trng.samp.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.services.CustomerServiceImpl;
import trng.samp.spring.utils.HibernateUtils;

@Repository
public class CustDaoImpl implements CustDaoInt {

	final static Logger logger = Logger.getLogger(CustDaoImpl.class);

	SessionFactory sf;

	public CustDaoImpl() {
		sf = HibernateUtils.getSessionFactory();
	}

	public boolean addCustomer(Customers cust) {
		logger.debug("Add Customer DAO method called.");
		System.out.println("Customer object" + cust);
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.save(cust);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public boolean deleteCustomerByHql(Long custID) {
		logger.debug("Delete Customer DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		try {
			Query query = session.createQuery("delete Customers where custId =:custID");
			query.setParameter("custID", custID);
			query.executeUpdate();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateCustomer(Customers cust) {
		logger.debug("Update Customer DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.update(cust);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;

	}

	public Customers loadCustomer(Long custID) {
		logger.debug("Load Customer DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		Customers customer = (Customers) session.get(Customers.class, custID);
		sf.openSession().close();
		return customer;
	}

	public boolean deleteCustomer(Long custID) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.delete(custID);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public List<Customers> getZipCustomers(int zipCode) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customers where zipCode = :zipCode");
		query.setParameter("zipCode", zipCode);
		List<Customers> custList = new ArrayList<Customers>();
		custList = query.list();
		return custList;
	}

}
