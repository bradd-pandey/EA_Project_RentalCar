package ea.project.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.domain.Customer;
import ea.project.repository.CustomerRepository;
import ea.project.service.ICustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public Collection<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (Collection<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByUserName(String userName) {
		// TODO Auto-generated method stub
		return customerRepository.findByusername(userName);
	}

//	@Override
//	public Customer findCustomerByUserNameAndPassword(String userName, String password) {
//		// TODO Auto-generated method stub
//		return customerRepository.findCustomerByUserName(userName);
//		//return customerRepository.findCustomerByUserNameAndPassword(userName, password);
//	}

}
