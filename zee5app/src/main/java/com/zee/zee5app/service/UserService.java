package com.zee.zee5app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.EntryExistsException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public interface UserService {

	public User insertUser(User user) throws UnableToGenerateIdException, EntryExistsException;
	public User updateUserById(String userId,User user);
	public String deleteUserById(String userId) throws NoDataFoundException;
	public Optional<List<User>> getAllUsers();
	public User getUserById(String userId);
}
