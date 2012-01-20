package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.CharacterStats;
import com.twelvetwentyseven.regdar.common.GameCharacter;
import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

// Mob is a Notch term
// Basically - it extends from Entity - but it's the alive things - players, npcs, monsters.
public class Mob extends Entity{
	// Each mob - plays as a character
	protected GameCharacter myCharacter;
	protected CharacterStats currStats;
	protected Weapon currWeapon;
	

	public Mob(Location myLocation, GameCharacter currChar) {
		super(myLocation);
		// TODO Auto-generated constructor stub
		myCharacter = currChar;
		currStats = currChar.getStats();
	}
	
	public void updateStats(CharacterStats updStats){
		currStats = updStats;
	}
	
	public void changeWeapon(Weapon newWeapon){
		currWeapon = newWeapon;
	}
	
	public void updateLocation(Location newLocation){
		location = newLocation;
	}
	
	// All mobs can take items
	public void takeItem(Item newItem){
		// add item to inventory - 
		newItem.pickedUp(this);
		
		//Switch case on type
		switch( newItem.type){
			case EntityType.MONEY:
				this.money += newItem.money;
				break;
				// Not everything gets added to inventory -
			default:
				myInventory.add(newItem);
				break;
		}
		
		newItem.removeFromMap();
	}
	
	public void dropItem(Item droppedItem){
		myInventory.remove(droppedItem);
		droppedItem.location = location;
		// Let the zone know
		location.getZone().addItem(droppedItem);
	}
}
