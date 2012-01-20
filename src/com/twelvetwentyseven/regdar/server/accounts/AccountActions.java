package com.twelvetwentyseven.regdar.server.accounts;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.twelvetwentyseven.regdar.common.Account;
import com.twelvetwentyseven.regdar.common.CharacterStats;
import com.twelvetwentyseven.regdar.common.Network.login;
import com.twelvetwentyseven.regdar.common.User;
import com.twelvetwentyseven.regdar.server.db.DBConnection;

// Should this class be static?
public class AccountActions {
	private DBConnection db;
	
	public AccountActions() throws SQLException, Exception{
		db = new DBConnection();
	}
	
	public User loginUser(login mLogin) throws Exception{
		// try to log the user in - if it fails
		User myUser = null;
			boolean retVal = false;
			int rowCount;
			ResultSet resultSet = null;
			resultSet = db.runQuery("select * from regdarusers where name = '" + mLogin.name + "' and password = '" + mLogin.password + "'");
			
			resultSet.last();
			rowCount = resultSet.getRow();
			
			if(rowCount > 0) {
				// If we are a user - log the user in
				
				if( db.runUpdate("update regdarusers set \"loggedIn\" = true where name = '" + mLogin.name + "'") > 0) {
					myUser = new User();
					myUser.associateUser(mLogin.name);
					
				}
			}

		return myUser;
	}
	
	public static Character createCharacter(User myUser){
		CharacterStats myStats;
		myStats = null; // null for now
		// Not working for now - try tomorrow
		Character myChar = null;// = new Character(myStats);
		
		// Associate the Character with the user
		
		return myChar;
	}
	
	public static Account createUserAccount(User currUser){
		// Create an account for this user 
		Account myAccount = new Account(currUser);
		
		return myAccount;
	}

}
