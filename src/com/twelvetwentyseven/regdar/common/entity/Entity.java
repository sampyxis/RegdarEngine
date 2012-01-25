package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.CharacterRace;
import com.twelvetwentyseven.regdar.common.CharacterType;
import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

// Base entity
public abstract class Entity {
	protected Location location;
	protected int health;
	protected int cost;
	// Alive is alive - when we need to - we destroy this when we're not alive
	protected boolean alive;
	// Active - is alive - and playing
	protected boolean active;
	protected String description;
	protected EntityAttributes myAttributes;
	protected int strength;
	protected int speed;
	// Should be moved to mob
	protected Inventory myInventory;
	protected int money;
	protected int dexterity;
	protected int intelligence;
	protected int stanima;
	protected int type;
	
	// Entity attributes
	// Need getters and setters
	public String name = "";
	public int HP = 0;
	public String desc = "";
	public int perception = 0;
	public CharacterRace charRace;
	public CharacterType charType;
	
	public Entity(Location myLocation) {
		location = myLocation;
	}
	
	public boolean update(){
		//Update only what is necessary
		// If my alive is false - destroy myself
		if(!alive) {
			destroy();
		}
		
		boolean wasUpdated = false;
		return wasUpdated;
	}
	
	public boolean forceUpdate(){
		//Force update for everything
		boolean wasUpdated = false;
		return wasUpdated;
	}
	
	public void setAlive(boolean newAlive){
		alive = newAlive;
		// Each subclass needs to ensure that it calls the zone manager when this status changes
	}
	
	public void setActive(boolean newActive){
		// Tell zone about the change
		active = newActive;
		
		if(location.getZone() != null){
			location.getZone().setEntityActiveStatus(this);
		}
	}
	
	public void heal(int pts){
		health += pts;
	}
	
	// Getters and Setters
	public Location getLocation() {
		return location;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getCost(){
		return cost;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public int getPerception() {
		return perception;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public EntityAttributes getAttributes(){
		return myAttributes;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public Inventory getInventory(){
		return myInventory;
	}
	
	public int getMoney(){
		return money;
	}
	
	public int getStanima(){
		return stanima;
	}
	
	public int getDexterity(){
		return dexterity;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getType(){
		return type;
	}
	
	
	public void setLocation(Location newLocation){
		location = newLocation;
	}
	
	public void destroy(){
		
	}
}

