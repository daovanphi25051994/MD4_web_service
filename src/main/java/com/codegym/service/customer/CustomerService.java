package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer model) {
        return customerRepository.save(model);
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public boolean remove(Long id) {
        Customer customer = getOne(id);
        if (customer != null){
            customerRepository.delete(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean removeAll() {
        customerRepository.deleteAll();
        return true;
    }
}