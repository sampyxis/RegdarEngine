package com.twelvetwentyseven.regdar.common.zone;

import java.util.ArrayList;

import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.entity.Entity;
import com.twelvetwentyseven.regdar.common.entity.Item;
import com.twelvetwentyseven.regdar.common.entity.Monster;
import com.twelvetwentyseven.regdar.common.entity.NPC;
import com.twelvetwentyseven.regdar.common.entity.Player;
import com.twelvetwentyseven.regdar.common.entity.Spell;
import com.twelvetwentyseven.regdar.common.entity.Weapon;

// Base zone
public class Zone {
	private int kmSize = 100;
	private int numPlayers = 0;
	private int numActivePlayers = 0;
	private int numNPCs = 0;
	private int numActiveNPCs = 0;
	private int numItems = 0;
	private int numActiveItems = 0;
	private String zoneName = "";
	private long zoneID = 0;
	
	// Keep track of what is in my zone
	private ArrayList<Player> zonePlayers;
	private ArrayList<Item> zoneItems;
	private ArrayList<Weapon> zoneWeapons;
	private ArrayList<Monster> zoneMonsters;
	private ArrayList<NPC> zoneNPCs;
	private ArrayList<Spell> zoneSpells;
	
	// Keep track of what is active in my zone
	private ArrayList<Player> zonePlayersActive;
	private ArrayList<Item> zoneItemsActive;
	private ArrayList<Weapon> zoneWeaponsActive;
	private ArrayList<Monster> zoneMonstersActive;
	private ArrayList<NPC> zoneNPCsActive;
	private ArrayList<Spell> zoneSpellsActive;
	
	public Zone(){
		//Intialize this zone
		zonePlayers = new ArrayList<Player>();
		zoneItems = new ArrayList<Item>();
		zoneWeapons = new ArrayList<Weapon>();
		zoneMonsters = new ArrayList<Monster>();
		zoneNPCs = new ArrayList<NPC>();
		zoneSpells = new ArrayList<Spell>();
		zonePlayersActive = new ArrayList<Player>();
		zoneItemsActive = new ArrayList<Item>();
		zoneWeaponsActive = new ArrayList<Weapon>();
		zoneMonstersActive = new ArrayList<Monster>();
		zoneNPCsActive = new ArrayList<NPC>();
		zoneSpellsActive = new ArrayList<Spell>();		
	}

	public long getZoneID() {
		return zoneID;
	}
	
	public void addPlayer(Player newPlayer){
		zonePlayers.add(newPlayer);
	}
	
	public void addItem(Item newItem){
		zoneItems.add(newItem);
	}
	
	public void addWeapon(Weapon newWeapon){
		zoneWeapons.add(newWeapon);
	}
	
	public void addMonster(Monster newMonster){
		zoneMonsters.add(newMonster);
	}
	
	public void addNPCs(NPC newNPCs){
		zoneNPCs.add(newNPCs);
	}
	
	public void addSpells(Spell newSpell){
		zoneSpells.add(newSpell);
	}

	public void removePlayer(Player newPlayer){
		zonePlayers.remove(newPlayer);
		zonePlayersActive.remove(newPlayer);
	}
	
	public void removeItem(Item newItem){
		zoneItems.remove(newItem);
		zoneItemsActive.remove(newItem);
	}
	
	public void removeWeapon(Weapon newWeapon){
		zoneWeapons.remove(newWeapon);
		zoneWeaponsActive.remove(newWeapon);
	}
	
	public void removeMonster(Monster newMonster){
		zoneMonsters.remove(newMonster);
		zoneMonstersActive.remove(newMonster);
	}
	
	public void removeNPCs(NPC newNPC){
		zoneNPCs.remove(newNPC);
		zoneNPCsActive.remove(newNPC);
	}
	
	public void removeSpells(Spell newSpells){
		zoneSpells.remove(newSpells);
		zoneSpellsActive.remove(newSpells);
	}
	
	public void setEntityActiveStatus(Entity newEntity){
		// Switch on type - set alive - add/remove the correct list
		// Untl 
		switch (newEntity.getType()){
			case EntityType.PLAYER:
				
				break;
			case EntityType.MONSTER:
				break;
			case EntityType.NPC:
				break;
			case EntityType.ITEM:
				break;
			case EntityType.SPELL:
				break;
			case EntityType.WEAPON:
				break;
		}
	}
	
	
	/*
	 * Can send in any type of item and it'll figure out the right one to remove
	 */
	public void removeItemFromMap(Item removedItem){
		// Switch on type - set alive - add/remove the correct list
		// Untl 
		switch (removedItem.getType()){
			case EntityType.ITEM:
				removeItem(removedItem);
				break;
			case EntityType.SPELL:
				removeSpells((Spell)removedItem);
				break;
			case EntityType.WEAPON:
				removeWeapon((Weapon)removedItem);
				break;
		}
	}
	
	public String getZoneName(){
		return zoneName;
	}
	
	public int getkmSize(){
		return kmSize;
	}
	
	public int getnumPlayers(){
		return numPlayers;
	}
	
	public int getnumActivePlayers(){
		return numActivePlayers;
	}
	
	public int getnumNPCs(){
		return numNPCs;
	}
	
	public int getnumActiveNPCs(){
		return numActiveNPCs;
	}
	
	public int getnumItems() {
		return numItems;
	}
	
	public int getnumActiveItems(){
		return numActiveItems;
	}
	
	// Update the zone
	public boolean updateZone(){
		boolean wasUpdated = false;
		
		// Only update what is necessary in the zone
		return wasUpdated;
	}
	
	public boolean forceUpdate(){
		boolean wasUpdated = false;
		
		//force the update - so update everything
		return wasUpdated;
	}
	
	public boolean serialize(){
		//Serialize this zone to disk (db)
		boolean wasUpdated = false;
		return wasUpdated;
	}
}
