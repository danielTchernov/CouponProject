package com.daniel.server.dal;

import com.daniel.server.beans.Customer;
import com.daniel.server.entities.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomerDal extends CrudRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c")
    List<Customer> getAllCustomers(int offset);

    @Query("SELECT c FROM CustomerEntity c ORDER BY amountOfChildren ASC")
    List<Customer> getAllCustomersByAmountOfChildrenAscending(int offset);

    @Query("SELECT c FROM CustomerEntity c ORDER BY amountOfChildren DESC")
    List<Customer> getAllCustomersByAmountOfChildrenDesc(int offset);
}
