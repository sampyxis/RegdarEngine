package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.base.DamageType;
import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;


public class Item extends Entity {

	private DamageType dmgType;
	private int damage;
	private boolean inInventory;
	private Mob owner;
	
	public Item(Location myLocation) {
		
		super(myLocation);
		// TODO Auto-generated constructor stub
		type = EntityType.ITEM;
		inInventory = false;
		
	}
	
	public DamageType getDamageType(){
		return dmgType;
	}
	
	public int getDamage() {
		return damage; // plus some randomness
	}

	public void removeFromMap(){
		// When this item gets picked up - or whenever
		// We need to remove this item from the map
		// It's now in inventory
		getLocation().getZone().removeItemFromMap(this);
		
	}
	
	public void pickedUp(Mob myMob){
		//Mark this item as picked up
		inInventory = true;
		owner = myMob;
	}
	
	public void dropped(Location newLocation){
		//I was dropped - where
		setLocation(newLocation);
		//I'm no longer in invetory or owned
		owner = null;
		inInventory = false;
	}
}

