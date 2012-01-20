package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.GameCharacter;
import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

public class NPC extends Mob{

	public NPC(Location myLocation, GameCharacter currChar) {
		super(myLocation, currChar);
		// TODO Auto-generated constructor stub
		type = EntityType.NPC;
	}

}
