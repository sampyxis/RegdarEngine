package com.twelvetwentyseven.regdar.common;

//A player can have multiple characters
//Need to store the Character stats and location at all times
public class GameCharacter {
	private CharacterStats myStats;
	private CharacterRace myRace;
	private CharacterType myType;
	
	public GameCharacter(CharacterStats myStats){
		myStats = myStats;
		
	}
	
	public CharacterStats getStats(){
		return myStats;
	}

}
