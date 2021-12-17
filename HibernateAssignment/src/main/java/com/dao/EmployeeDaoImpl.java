package com.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.exception.ApplicationException;
import com.model.Department;
import com.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int saveDepartmentDao(Department department) throws ApplicationException {
		int result = 0;
		if (department != null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(department); 
			transaction.commit(); 
			result++;
			session.close(); 
			factory.close(); 

		} else {
			throw new ApplicationException("No Department Created");
		}
		return result;
	}

	@Override
	public List<Employee> readDepartmentDao() throws ApplicationException {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction(); 

		String readAllHql = "from Employee";
		List<Employee> employeeList = session.createQuery(readAllHql).list();

		return employeeList;
	}

	@Override
	public int updateEmployeeDao(Employee employee) throws ApplicationException {
		int result = 0;
		if (employee != null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			session.update(employee); 
			result ++;
			transaction.commit(); 
		} else {
			throw new ApplicationException("Invalid data");
		}
		return result;
	}

	@Override
	public int deleteEmployeeDao(int deleteId) throws ApplicationException {
		int delete = 0;
		if (deleteId != 0) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			Query hql = session.createQuery("delete from Employee e where e.id= :x");
	        hql.setParameter("x", deleteId);
	        delete = hql.executeUpdate();
	        transaction.commit();
	        session.close();
		} else {
			throw new ApplicationException("Invalid input");
		}
		return delete;
	}

}
