package ea.project.service;

import java.util.Collection;

import ea.project.domain.Customer;

public interface ICustomerService {
	public void addCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Collection<Customer> getCustomers();
	public Customer findCustomerByUserName(String userName);
	//public Customer findCustomerByUserNameAndPassword(String userName, String password);
}
