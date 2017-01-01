package ea.project.controller;


   
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.Customer;
import ea.project.domain.Customer.Role;
import ea.project.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@RequestMapping(value={"/showCustomer"}, method = RequestMethod.GET)
	public String showCustomers(Model model){
		Collection<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "clientList";
	}
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.GET)
	public String addCustomer(@ModelAttribute("newCustomer") Customer customer, Model model){
		return "addCustomer";
	}
	
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request){
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError oe: allErrors) {
				System.out.println(oe.getDefaultMessage());
			}			
			return "addCustomer";
		}
		customer.setAuthority(Role.ROLE_USER);
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		redirectAttributes.addFlashAttribute(customer);
		return "redirect:/login";
	}
}
