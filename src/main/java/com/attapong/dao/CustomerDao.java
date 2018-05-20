package com.attapong.dao;

import java.util.List;

import com.attapong.entity.Customer;

public interface CustomerDao {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int id);
}
