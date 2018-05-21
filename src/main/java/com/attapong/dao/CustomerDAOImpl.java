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

	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public List<Customer> searchCustomer(String name) {

		Session session = sessionFactory.getCurrentSession();
		Query query = null;
		if (name != null && name.trim().length() > 0) {
			
			System.out.println("name not null");
			 query = session.createQuery(
					"from Customer where lower(firstName) like :name or lower(lastName) like :name", Customer.class);
			 
			query.setParameter("name", "%" + name.toLowerCase() + "%");
		}else {
			 query = session.createQuery(
						"from Customer", Customer.class);
		}
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
