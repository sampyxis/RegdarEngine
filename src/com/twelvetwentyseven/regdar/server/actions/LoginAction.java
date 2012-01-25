package com.twelvetwentyseven.regdar.server.actions;

import java.sql.SQLException;

import com.twelvetwentyseven.regdar.common.Network.login;
import com.twelvetwentyseven.regdar.common.User;
import com.twelvetwentyseven.regdar.server.accounts.AccountActions;

public class LoginAction {
	
	public LoginAction() {
		
	}
	
	//
	public User loginUser(login mLogin){
		boolean retVal = false;
		User newUser = null;
	    AccountActions account = null;
		try {
			account = new AccountActions();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
	    	newUser = account.loginUser(mLogin);
			if ( newUser == null) {
				retVal = false;
			 } else {
				 retVal = true;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return newUser;

	}
	//
	

}
