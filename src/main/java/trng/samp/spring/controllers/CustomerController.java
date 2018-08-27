package trng.samp.spring.controllers;

import org.springframework.stereotype.Controller;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.services.CustomerServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/CustomerCRUD")
public class CustomerController {

	@Autowired
	CustomerServiceInt csi;

	Customers cust = new Customers();

	// Test Handler
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		return "index";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String crud() {
		return "CustomerCRUD";
	}

	@RequestMapping(value = "/loadCustomer", method = RequestMethod.GET)
	public Customers loadCustomer(@PathVariable("custID") long id) {
		return csi.loadCustomer(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customers cust) {
		csi.addCustomer(cust);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customers cust) {
		boolean status = csi.updateCustomer(cust);
	}

	@RequestMapping(value = "/{custID}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("custID") long id) {
		csi.deleteCustomerByHql(id);
	}

}
