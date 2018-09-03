package trng.samp.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.pojo.Orders;
import trng.samp.spring.utils.HibernateUtils;

@Repository
public class OrderDaoImpl implements OrderDaoInt {
	
	final static Logger logger = Logger.getLogger(CustDaoImpl.class);
	
	SessionFactory sf;
	
	public OrderDaoImpl() {
		sf = HibernateUtils.getSessionFactory();
	}

	public boolean createOrder(Orders order) {
		logger.debug("Create Order DAO method called.");
		System.out.println("Order"+ order);
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.save(order);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public boolean updateOrder(Orders order) {
		logger.debug("Update Order DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.update(order);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public boolean deleteOrder(Long orderID) {
		logger.debug("Delete Order DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		try {
		Query query = session.createQuery("delete Orders where orderId =:orderID");
		query.setParameter("orderID", orderID);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Orders getOrder(Long orderID) {
		logger.debug("Get Order DAO method called.");
		Session session = sf.openSession();
		session.getTransaction().begin();
		Orders order = (Orders) session.get(Orders.class, orderID);
		sf.openSession().close();
		return null;
	}
	
	

}
