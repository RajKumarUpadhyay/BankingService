package com.bank.money.transfer.dao;

import static junit.framework.TestCase.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.money.transfer.exception.CustomException;
import com.bank.money.transfer.model.User;

public class TestUserDAO {
	
	private static Logger log = Logger.getLogger(TestUserDAO.class);
	
	private static final DAOFactory h2DaoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);

	@BeforeClass
	public static void setup() {
		log.debug("setting up test database and sample data....");
		h2DaoFactory.populateTestData();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testGetAllUsers() throws CustomException {
		List<User> allUsers = h2DaoFactory.getUserDAO().getAllUsers();
		assertTrue(allUsers.size() > 1);
	}

	@Test
	public void testGetUserById() throws CustomException {
		User u = h2DaoFactory.getUserDAO().getUserById(2L);
		assertTrue(u.getUserName().equals("test1"));
	}

	@Test
	public void testGetNonExistingUserById() throws CustomException {
		User u = h2DaoFactory.getUserDAO().getUserById(500L);
		assertTrue(u == null);
	}

	@Test
	public void testGetNonExistingUserByName() throws CustomException {
		User u = h2DaoFactory.getUserDAO().getUserByName("abcdeftg");
		assertTrue(u == null);
	}

	@Test
	public void testCreateUser() throws CustomException {
		User u = new User("liandre", "liandre@gmail.com");
		long id = h2DaoFactory.getUserDAO().insertUser(u);
		User uAfterInsert = h2DaoFactory.getUserDAO().getUserById(id);
		assertTrue(uAfterInsert.getUserName().equals("liandre"));
		assertTrue(u.getEmailAddress().equals("liandre@gmail.com"));
	}

	@Test
	public void testUpdateUser() throws CustomException {
		User u = new User(1L, "test2", "test2@gmail.com");
		int rowCount = h2DaoFactory.getUserDAO().updateUser(1L, u);
		assertTrue(rowCount == 1);
		assertTrue(h2DaoFactory.getUserDAO().getUserById(1L).getEmailAddress().equals("yanglu@gmail.com"));
	}

	@Test
	public void testUpdateNonExistingUser() throws CustomException {
		User u = new User(500L, "test2", "test2@gmail.com");
		int rowCount = h2DaoFactory.getUserDAO().updateUser(500L, u);
		assertTrue(rowCount == 0);
	}

	@Test
	public void testDeleteUser() throws CustomException {
		int rowCount = h2DaoFactory.getUserDAO().deleteUser(1L);
		assertTrue(rowCount == 1);
		assertTrue(h2DaoFactory.getUserDAO().getUserById(1L) == null);
	}

	@Test
	public void testDeleteNonExistingUser() throws CustomException {
		int rowCount = h2DaoFactory.getUserDAO().deleteUser(500L);
		assertTrue(rowCount == 0);

	}

}
