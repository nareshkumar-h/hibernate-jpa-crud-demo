package com.charityapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.charityapp.model.Gender;
import com.charityapp.model.User;

public class UserDAOTest {

	private static UserDAO userDAO = new UserDAO();

	public static void main(String[] args) {
		// testAddUser();
		// testFindOne();
		// testUpdateUser();
		// testDeleteUser();
		//testListUsers();
		//testFindByEmailAndPassword();
		//testFindInvalidEmailAndPassword();

	}

	public static void testFindOne() {
		Integer id = 1;
		User user = userDAO.findOne(id);
		System.out.println(user);
	}

	public static void testAddUser() {

		User user = new User();
		user.setName("Naresh");
		user.setEmail("nareshkumarh@live.com");
		user.setPassword("pass123");
		user.setActive(true);
		user.setGender(Gender.MALE);
		//user.setCreatedDate(LocalDateTime.now());
		//user.setModifiedDate(LocalDateTime.now());

		userDAO.save(user);
	}

	public static void testUpdateUser() {

		Integer id = 3;
		User user = userDAO.findOne(id);
		user.setName("Naresh Kumar"); // update name
		userDAO.update(user);
	}

	public static void testDeleteUser() {

		Integer id = 1;
		userDAO.delete(id);

	}

	public static void testListUsers() {
		List<User> list = userDAO.list();
		for (User user : list) {
			System.out.println(user);
		}
	}

	public static void testFindByEmailAndPassword() {
		User user = userDAO.findByEmailAndPassword("nareshkumarh@live.com", "pass123");
		System.out.println(user);
	}
	
	public static void testFindInvalidEmailAndPassword() {
		User user = userDAO.findByEmailAndPassword("nareshkumarh@live.com", "p");
		System.out.println(user);
	}
}
