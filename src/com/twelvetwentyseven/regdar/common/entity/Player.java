package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.CharacterStats;
import com.twelvetwentyseven.regdar.common.GameCharacter;
import com.twelvetwentyseven.regdar.common.User;
import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;
import com.twelvetwentyseven.regdar.common.quests.QuestList;
import com.twelvetwentyseven.regdar.common.zone.Zone;


public class Player extends Mob{
	private User playerUser;
	private String AccountID;
	private QuestList myQuestList;
	private Zone myZone;


	public Player(Location myLocation, User currUser, GameCharacter userCharacter) {
		
		super(myLocation, userCharacter);
		// Set the User/Char
		playerUser = currUser;
		myCharacter = userCharacter;
		
		// Initialize vars
		myQuestList = new QuestList();
		type = EntityType.PLAYER;
		alive = true;
				
		//Add me to a zone
		myZone = myLocation.getZone();
		myZone.addPlayer(this);

	}
	
	public boolean update(){
		super.update();
	
		boolean wasUpdated = false;
		return wasUpdated;
	}
	
	public boolean forceUpdate(){
		super.forceUpdate();
		boolean wasUpdated = false;
		return wasUpdated;
	}
	
	public void setAlive(boolean newAlive){
		super.setAlive(newAlive);
		
		// this is normally a dead state (I think always a dead state)
		if (alive==false){
			//Tell my zone (if I have one) - 
			if(location.getZone() != null){
				location.getZone().removePlayer(this);
			}
		}
		
	}
	
	
	public QuestList getQuestList(){
		return myQuestList;
	}

	public String getAccountID(){
		return AccountID;
	}
	
	public int getNumQuests(){
		return myQuestList.size();
	}
	
	
	
}
