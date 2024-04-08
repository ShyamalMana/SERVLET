package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Studentdto;

public class Studentdao 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shyam");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void save_student(Studentdto s)
	{
		et.begin();
		em.persist(s);
		et.commit();
		
	}
	public List<Studentdto> findall_students()
	{
		Query q = em.createQuery("select s from Studentdto s");
		List<Studentdto> list =q.getResultList();
		return list;
	}
	
	public Studentdto findStudentbyId(int id)
	{
		return em.find(Studentdto.class, id);
		
	}
	
	public void updateStudent(Studentdto s)
	{
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	public void deleteStudent(Studentdto s)
	{
		et.begin();
		em.remove(s);
		et.commit();
		
	}

}
