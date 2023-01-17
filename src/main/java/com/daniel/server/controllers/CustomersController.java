package com.daniel.server.controllers;

import com.daniel.server.beans.Company;
import com.daniel.server.beans.Customer;
import com.daniel.server.entities.CustomerEntity;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.CustomerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private CustomerLogic customerLogic;

    @Autowired
    public CustomersController(CustomerLogic customerLogic){
        this.customerLogic = customerLogic;
    }

    @PostMapping
    public void createCustomer (@RequestBody CustomerEntity customer) throws Exception {
        customerLogic.createCustomer(customer);
    }

    @PutMapping
    public void updateCustomer (@RequestBody CustomerEntity customer) throws Exception {
        customerLogic.updateCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public void removeCustomer (@PathVariable ("customerId") long id) throws Exception {
        customerLogic.remove(id);
    }

    @GetMapping("{customerId}")
    public CustomerEntity getCustomer(@PathVariable("customerId") long id) throws Exception {
        CustomerEntity customer = customerLogic.getCustomer(id);
        return customer;
    }

    @GetMapping
    public List<Customer> getAllCustomers(@RequestParam("page") int page) throws ServerException {
        List<Customer> customers = customerLogic.getAllCustomers(page);
        return customers;
    }

    @GetMapping("/ByChildrenAsc")
    public List<Customer> getAllCustomersByAmountOfChildrenAscending(@PathVariable("page") int page) throws ServerException {
        List<Customer> customers = customerLogic.getAllCustomersByAmountOfChildrenAscending(page);
        return customers;
    }

    @GetMapping("/ByChildrenDes")
    public List<Customer> getAllCustomersByAmountOfChildrenDesc(@PathVariable("page") int page) throws ServerException {
        List<Customer> customers = customerLogic.getAllCustomersByAmountOfChildrenDesc(page);
        return customers;
    }


}
