package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Employee;

public class Employee_dao 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shyam");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void Save_Employee(Employee e)
	{
		et.begin();
		em.persist(e);
		et.commit();
	}
	public List<Employee> FindALL_Employee()
	{
		Query q = em.createQuery("select e from Employee e");
		List <Employee>list = q.getResultList();
		return list;
		
	}
	public Employee FindEmployeeById(int id)
	{
	   Employee e=em.find(Employee.class, id);
	   return e;
	}
	
	public void updateEmployee(Employee e)
	{
		et.begin();
		em.merge(e);
		et.commit();
	}
	
	public void Delete_Employee(Employee e)
	{
		et.begin();
		em.remove(e);
		et.commit();
	}
	
	
	

}
