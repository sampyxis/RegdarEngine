package com.twelvetwentyseven.regdar.common;

import java.sql.SQLException;

public class UserFactory {

	public UserFactory(){
		
	}
	public User createUser(String name, String email, String password){
		User createdUser = null;
		try {
			createdUser = new User();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			createdUser.createUser(name, email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdUser;
	}

}
