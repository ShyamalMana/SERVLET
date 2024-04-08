package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Employee;

public class Employee_Signup_dao 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shyam");
	EntityManager em= emf.createEntityManager();
	EntityTransaction et =em.getTransaction();
	
	
	public void save_employee(Employee e)
	{
		et.begin();
		em.persist(e);
		et.commit();
	}
	public List<Employee> findall_employee()
	{
		Query q = em.createQuery("select e from Employee e");
		List<Employee> lst = q.getResultList();
		return lst;
	}

}
