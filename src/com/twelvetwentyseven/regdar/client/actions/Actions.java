package com.twelvetwentyseven.regdar.client.actions;

import com.twelvetwentyseven.regdar.common.Account;
import com.twelvetwentyseven.regdar.common.CharacterStats;
import com.twelvetwentyseven.regdar.common.User;

// Holds the actions
public final class Actions {

	public Actions(){
		
	}
	
	public void createCharacter(User myUser){
		CharacterStats myStats;
		myStats = null; // null for now
		// Not working for now - try tomorrow
		Character myChar;// = new Character(myStats);
		
		// Associate the Character with the user
		
		
	}
	
	public void createAccount(User currUser){
		// Create an account for this user 
		Account myAccount = new Account(currUser);
	}
	
	public void perceptionCheck(){
		// Perform a perception check on the server
	}
	
	
}
