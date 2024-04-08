package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.controller.Student;

public class StudentDao 
{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("shyam");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void saveStudent(Student s) {
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	public List<Student> findAllStudentDetails() {
		Query q=em.createQuery("select s from Student s");
		List<Student> list=q.getResultList();
		return list;
	}
	
	public Student findStudentById(int id) {
		return em.find(Student.class,id);
	}

	public void updateStudent(Student s) {
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	public void deleteStudent(Student s) {
		et.begin();
		em.remove(s);
		et.commit();
	}


}
