package com.attapong.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.attapong.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	public Customer getCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, id);

		return customer;
	}

}
