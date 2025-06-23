package FIb3.Smekhow.OnlineShop.Service;

import FIb3.Smekhow.OnlineShop.Model.Customer;
import FIb3.Smekhow.OnlineShop.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements IService<Customer> {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer)
    {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id)
    {
        return customerRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(int id, Customer customerDetails)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Не существует покупателя с таким id: %d".formatted(id))
        );
        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setCustomerPhone(customerDetails.getCustomerPhone());
        customer.setCustomerType(customerDetails.getCustomerType());
        return customerRepository.save(customer);
    }

    @Override
    public void delete(int id)
    {
        customerRepository.deleteById(id);
    }

}
