package trng.samp.spring.dao;

import trng.samp.spring.pojo.Orders;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.pojo.OrderItems;

public interface OrderDaoInt {
	
	public boolean createOrder(Orders order);
	public boolean updateOrder(Orders order);
	public boolean deleteOrder(Long orderID);
	public Orders getOrder(Long orderID);
	

}
