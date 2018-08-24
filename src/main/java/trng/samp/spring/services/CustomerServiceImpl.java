package trng.samp.spring.services;

import org.springframework.stereotype.Service;
import trng.samp.spring.dao.CustDaoImpl;
import trng.samp.spring.pojo.Customers;

@Service
public class CustomerServiceImpl implements CustomerServiceInt{
	
	CustDaoImpl cdi = new CustDaoImpl();

	@Override
	public boolean addCustomer(Customers cust) {
		cdi.addCustomer(cust);
		return true;
	}

	@Override
	public boolean deleteCustomerByHql(Long custID) {
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
		cdi.updateCustomer(cust);
		return true;
	}

	@Override
	public Customers loadCustomer(Long custID) {
		Customers cust = cdi.loadCustomer(custID);
		return cust;
	}

}
