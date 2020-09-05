package com.charityapp.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final String PERSISTENT_UNIT_NAME = "CharityAppJPA";
	
	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		}
		return emf;
	}
}

// Hibernate
// 1. Hibernate Own => SessionFactory
// 2. JPA => EntityManagerFactory