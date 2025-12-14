package com.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;

public class JpMorganPractice {

	
	public static void main(String[] args) {
		//User - Entity 
			// Name,age
		
		
		// In memeory storage --- store-user, get-user-oldest.
		
		
	}
	
	//Entity
	class UserClass {
		
		
		String name;
		int age ;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		
	}
	
	
	class UserManagementLogic {
		
		TreeSet<User> userSet = new TreeSet<User>(Comparator.comparing(u->u.getAge()));
		
		public void storeUser(User user) {
			userSet.add(user);
			
		}
		
		public getUser() {
			
			userset.get(0);
		}
	}
	
}
