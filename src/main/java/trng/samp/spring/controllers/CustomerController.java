package trng.samp.spring.controllers;

import org.springframework.stereotype.Controller;
import trng.samp.spring.pojo.Customers;
import trng.samp.spring.services.CustomerServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping(value="/LoadCustomer", method = RequestMethod.GET)
	public String loadCustomer() {
		return "LoadCustomer";
	}

	@RequestMapping(value = "/LoadCustomer/{custID}", method = RequestMethod.POST)
	public String loadCustomer(@PathVariable("custID") String id , ModelMap model) {
		Long custID = Long.parseLong(id);
		Customers cust = csi.loadCustomer(custID);
		model.addAttribute("Customer", cust);
		return "PrintCustomer";
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
