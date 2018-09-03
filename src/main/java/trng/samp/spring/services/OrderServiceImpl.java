package trng.samp.spring.services;

import org.apache.log4j.Logger;

import trng.samp.spring.dao.OrderDaoImpl;
import trng.samp.spring.pojo.Orders;

public class OrderServiceImpl implements OrderServiceInt {
	
	final static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	OrderDaoImpl odi = new OrderDaoImpl();

	@Override
	public boolean createOrder(Orders order) {
		logger.debug("Create Order Service method called.");
		odi.createOrder(order);
		return true;
	}

	@Override
	public boolean updateOrder(Orders order) {
		logger.debug("Update Order Service method called.");
		odi.updateOrder(order);
		return true;
	}

	@Override
	public boolean deleteOrder(Long orderID) {
		logger.debug("Delete Order Service method called.");
		odi.deleteOrder(orderID);
		return false;
	}

	@Override
	public Orders getOrder(Long orderID) {
		logger.debug("Get Order Service method called.");
		Orders order = odi.getOrder(orderID);
		return order;
	}

}
