package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

public class Weapon extends Item {

	public Weapon(Location myLocation) {
		super(myLocation);
		// TODO Auto-generated constructor stub
		type = EntityType.WEAPON;
	}

}
