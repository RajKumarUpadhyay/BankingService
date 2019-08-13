package com.bank.money.transfer.dao;

import java.util.List;

import com.bank.money.transfer.exception.CustomException;
import com.bank.money.transfer.model.User;

public interface UserDAO {
	
	List<User> getAllUsers() throws CustomException;

	User getUserById(long userId) throws CustomException;

	User getUserByName(String userName) throws CustomException;

	/**
	 * @param user:
	 * user to be created
	 * @return userId generated from insertion. return -1 on error
	 */
	long insertUser(User user) throws CustomException;

	int updateUser(Long userId, User user) throws CustomException;

	int deleteUser(long userId) throws CustomException;

}
