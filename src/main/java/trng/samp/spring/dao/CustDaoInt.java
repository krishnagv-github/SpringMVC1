package trng.samp.spring.dao;

import trng.samp.spring.pojo.Orders;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.pojo.OrderItems;

public interface CustDaoInt {
	
	public boolean addCustomer(Customers cust);
	public boolean deleteCustomerByHql(Long custID);
	public boolean deleteCustomer(Long custID);
	public boolean updateCustomer(Customers cust);
	public Customers loadCustomer(Long custID);

}
