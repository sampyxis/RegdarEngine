package com.twelvetwentyseven.regdar.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.esotericsoftware.minlog.Log;
import com.twelvetwentyseven.regdar.server.db.DBConnection;

/*
 * A user has an account and multiple characters - and is a player when they play
 */
public class User {
	public String userName;
	public String userEmail;
	public String userPassword;
	
	public ArrayList<GameCharacter> myChars;
	public Account myAccount;
	
	private DBConnection db;

	public User() throws SQLException, Exception{
		// Create an instance of the db connection
		try{
		db = new DBConnection();
		} catch(SQLException e){
			Log.debug(e.getMessage());
		} catch (Exception e){
			Log.debug(e.getMessage());
		}
		
	}
	
	
	public void addCharacter(GameCharacter newCharacter){
		myChars.add(newCharacter);
	}
	
	public void writeUserToDB(){
		// Write the characters and other user info to db
	}
	
	public User associateUser(String newName) throws SQLException{
		ResultSet resultSet = null;
		resultSet = db.runQuery("select * from regdarusers where name = '" + newName  + "'");	
		int i;
		resultSet.last();
		i = resultSet.getRow();
		if(i > 0 ) {
			// We have a user
			// Next - we need to make sure we have only one row
			userName = resultSet.getString("name");
			userEmail = resultSet.getString("email");
			userPassword = resultSet.getString("password");
		}
		
		return this;
		
	}
	
	public boolean loginUser(String userName, String password) throws SQLException{
		boolean retVal = false;
		int rowCount;
		ResultSet resultSet = null;
		resultSet = db.runQuery("select * from regdarusers where name = '" + userName + "' and password = '" + password + "'");
		
		resultSet.last();
		rowCount = resultSet.getRow();
		
		if(rowCount > 0) {
			// If we are a user - log the user in
			
			if( db.runUpdate("update regdarusers set \"loggedIn\" = true where name = '" + userName + "'") > 0) {
				retVal = true;
			}
		}
		return retVal;
	}
	
	public void createUser(String newName, String newEmail, String newPassword) throws SQLException {
		
		// Do we already exist in the db?
		ResultSet resultSet = null;
		resultSet = db.runQuery("select * from regdarusers where name = '" + newName + "'");
		
		int i;
		resultSet.last();
		i = resultSet.getRow();
		if(i > 0 ) {
			// We have a user
			// Next - we need to make sure we have only one row
			userName = resultSet.getString("name");
			userEmail = resultSet.getString("email");
			userPassword = resultSet.getString("password");
		} else { // Not there - insert it
			// Create the User
			userName = newName;
			userEmail = newEmail;
			userPassword = newPassword;
			
			// Put a row in the db
			String query = "insert into regdarusers (\"name\", \"email\", \"password\") values ( '" + userName + "','" + userEmail + "','" + userPassword + "')";

			db.runInsertAuto(query);

		}

	}
}
