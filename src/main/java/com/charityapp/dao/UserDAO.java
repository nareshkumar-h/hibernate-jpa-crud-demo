package com.charityapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.charityapp.model.User;
import com.charityapp.util.JPAUtil;

public class UserDAO {

	private static final EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
	
	//Connection con =...
	//con.setAutoCommit(false);
	//q1 insert
	//q2 insert
	//con.commit();
	//Transaction Management 
	public void save(User user) {
	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);  // insert into users ( name,email,password) values (?,?,?);
		
		//em.persist(account1); deduct Rs.1000
		//em.persist(account2); add Rs.1000
		em.getTransaction().commit(); //commit
		em.close();
		
	}
	
	public User findOne(Integer id) {
		EntityManager em = emf.createEntityManager();
		User user  = em.find(User.class, id);//select * from users where id = ?
		em.close();
		return user;
	}
	
	public void update(User user) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user); //update users set name =? ,... where id = ?
		em.getTransaction().commit();
		em.close();
	}

	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User findOne = em.find(User.class,id);
		em.remove(findOne); //delete from users where id = ?
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> list(){
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("from User u", User.class); //select * from users
		List<User> list = query.getResultList();
		em.close();
		return list;
	}
	
	public User findByEmailAndPassword(String email, String password){
		User user = null;
		try {
			EntityManager em = emf.createEntityManager();
			TypedQuery<User> query = em.createQuery("from User u where email=?1 and password = ?2", User.class);
			query.setParameter(1, email);
			query.setParameter(2, password);
			user =  query.getSingleResult();
			em.close();
		} catch (NoResultException e) {			
		}
		return user;
	}
}
