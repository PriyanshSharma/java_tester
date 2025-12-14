package com.dev.lld.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.lld.models.User;

public class UserDAOImpl implements UserDAO {

	public static Map<String, User> userMap ;
	
	
	public UserDAOImpl() {
		userMap = new HashMap<String, User>();
	}
	
	
	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		
		return userMap.containsKey(userId)?userMap.get(userId):null;
	}

	@Override
	public User createUser(User user) {
		
		userMap.put(user.getId(), user);
		System.out.println("User saved..");
		return user;
		

	}


	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userMap.values();
	}

}
