package com.dev.lld.repository;

import java.util.List;

import com.dev.lld.models.User;

public interface UserDAO {

	public User getUser(String userId);
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
}
