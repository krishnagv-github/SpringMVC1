package trng.samp.spring.controllers;

import org.springframework.stereotype.Controller;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.services.CustomerServiceInt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Customers")
public class CustomerController {
	
	final static Logger logger = Logger.getLogger(CustomerController.class);

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
		logger.debug("Displaying CustomerCRUD page!");
		return "CustomerCRUD";
	}
	
	@RequestMapping(value="/LoadCustomer", method = RequestMethod.GET)
	public String loadCustomer() {
		logger.debug("Load Customer method called.");
		return "LoadCustomer";
	}

//	@RequestMapping(value = "/LoadCustomer/{custID}", method = RequestMethod.GET)
//	public String loadCustomer(@PathVariable("custID") String id , ModelMap model) {
//		Long custID = Long.parseLong(id);
//		Customers cust = csi.loadCustomer(custID);
//		model.addAttribute("Customer", cust);
//		return "PrintCustomer";
//	}
	
	@RequestMapping(value = "/LoadCustomer?custID={custID}", method = RequestMethod.GET)
	public String loadCustomer(@PathVariable("custID") String id , ModelMap model) {
		logger.debug("Load Customer method called.");
		Long custID = Long.parseLong(id);
		Customers cust = csi.loadCustomer(custID);
		model.addAttribute("Customer", cust);
		return "PrintCustomer";
	}


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customers cust) {
		logger.debug("Add Customer method called.");
		csi.addCustomer(cust);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customers cust) {
		logger.debug("Update Customer method called.");
		boolean status = csi.updateCustomer(cust);
	}

	@RequestMapping(value = "/{custID}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("custID") long id) {
		logger.debug("Delete Customer method called.");
		csi.deleteCustomerByHql(id);
	}

}
