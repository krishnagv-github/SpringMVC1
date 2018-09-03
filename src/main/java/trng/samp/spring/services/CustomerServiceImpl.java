package trng.samp.spring.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import trng.samp.spring.dao.CustDaoImpl;
import trng.samp.spring.pojo.Customers;

@Service
public class CustomerServiceImpl implements CustomerServiceInt{
	
	final static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	CustDaoImpl cdi = new CustDaoImpl();

	@Override
	public boolean addCustomer(Customers cust) {
		logger.debug("Add Customer Service method called.");
		cdi.addCustomer(cust);
		return true;
	}

	@Override
	public boolean deleteCustomerByHql(Long custID) {
		logger.debug("Delete Customer Service method called.");
		cdi.deleteCustomerByHql(custID);
		return true;
	}

	@Override
	public boolean deleteCustomer(Long custID) {
		cdi.deleteCustomer(custID);
		return true;
	}

	@Override
	public boolean updateCustomer(Customers cust) {
		logger.debug("Update Customer Service method called.");
		cdi.updateCustomer(cust);
		return true;
	}

	@Override
	public Customers loadCustomer(Long custID) {
		logger.debug("Load Customer Service method called.");
		Customers cust = cdi.loadCustomer(custID);
		return cust;
	}

}
