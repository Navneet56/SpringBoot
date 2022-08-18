package com.zee.zee5app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.EntryExistsException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

import com.zee.zee5app.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	
	 
	public User insertUser(User user) throws UnableToGenerateIdException, EntryExistsException
	{
		if(repo.existsByEmail(user.getEmail())|| repo.existsByUsername(user.getUsername()))
		{
			throw new EntryExistsException("all ready Exist");
		}
		return repo.save(user);
	}
	
	public Optional<List<User>> getAllUsers()
	{
		return Optional.ofNullable(repo.findAll());
	}
	
	public User getUserById(String userId)
	{
		//return repo.findById(userId);
		return repo.findById(userId).get();
	}
	
	public String deleteUserById(String userId) throws NoDataFoundException
	{
		try {
			if(repo.existsById(userId))
			{
				repo.deleteById(userId);
				return "Success";
			}
			
			else
			{
				throw new NoDataFoundException("No data found");
			}
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			// to handle any exception except nodatafoundexception.
			e.printStackTrace();
		}
		return "failed";
	}
	
	public User updateUserById(String userId,User user)
	{
		//return repo.updateUserById(userId, user);
		return null;
	}

}
