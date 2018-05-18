package com.attapong.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attapong.dao.CustomerDao;
import com.attapong.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	public List<Customer> getCustomers() {
		
		
		return customerDao.getCustomers();
	}

}
