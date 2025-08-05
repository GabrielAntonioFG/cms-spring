/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.gabrielflores.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.com.gabrielflores.cms.dao.CustomerDao;
import pe.com.gabrielflores.cms.exception.CustomerNotFoundException;
import pe.com.gabrielflores.cms.model.Customer;

/**
 *
 * @author gfloresgamb
 */
@Component
public class CustomerService {
    
    @Autowired
    private CustomerDao customerDAO;
    
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();
    
    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }
    
    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }
    
    public Customer getCustomer(int customerId){
        //return customerDAO.findById(customerId).get();
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer not found");
        return optionalCustomer.get();
    }
    
    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }
    
    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
    
    /*
    public Customer addCustomer(Customer customer){
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }
    
    public List<Customer> getCustomers(){
        return customerList;
    }
    
    public Customer getCustomer(int customerId){
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }
    
    public Customer updateCustomer(int customerId, Customer customer){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }
    
    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == customerId){
                        customerList.remove(c);
                    }
                });
    }
    */
}
