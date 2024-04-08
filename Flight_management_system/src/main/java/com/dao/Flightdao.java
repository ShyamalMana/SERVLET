package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Flight;

public class Flightdao
{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("shyam");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void save_flight(Flight f)
	{
		et.begin();
		em.persist(f);
		et.commit();
	}
	public List<Flight> FinfAll_flight()
	{
		Query q = em.createQuery("select f from Flight f");
		List<Flight> list = q.getResultList();
		return list;
	}
	public Flight findById(int id)
	{
		Flight l = em.find(Flight.class, id);
		return l;
		
	}
	
	public void update_flight(Flight f)
	{
		et.begin();
		em.merge(f);
		et.commit();
		
	}
	public void delete_flight(Flight f)
	{
		et.begin();
		em.remove(f);
		et.commit();
		
	}

}
