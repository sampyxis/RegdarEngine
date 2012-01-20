package com.twelvetwentyseven.regdar.server.zones;

import java.util.ArrayList;

import com.twelvetwentyseven.regdar.common.zone.Zone;

public class ZoneManagement {
	private ArrayList<Zone> zones;
	
	public ZoneManagement(){
		zones = new ArrayList<Zone>();
	}

	public void addZone(){
		// Not sure of the paramaters yet, but I want to create one for now
		Zone zone = new Zone();
		zones.add(zone);
	}
	
	public Zone getCharacterZone(Character myChar) {
		return zones.get(1); // get the first one for now
	}
}
