package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.Signup;

public class Signupdao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("shyam");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void savesignup(Signup s) {
		et.begin();
		em.persist(s);
		et.commit();

	}

}
