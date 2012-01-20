package com.twelvetwentyseven.regdar.common.base;

import com.twelvetwentyseven.regdar.common.zone.Zone;

// Base location class
// I want this to be lightweight
public class Location {
	private float x;
	private float y;
	private Zone myZone;

	public Location(float newX, float newY){
		x = newX;
		y = newY;
		determineZone();
	}
	
	public Zone getZone(){
		return myZone;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	private void SwitchZones(){
		
	}
	
	private void determineZone(){
		// Using x and y - figure out which zone the player is in
	}
}
