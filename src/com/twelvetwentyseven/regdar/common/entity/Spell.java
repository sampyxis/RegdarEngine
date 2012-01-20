package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

public class Spell extends Item {

	public Spell(Location myLocation) {
		super(myLocation);
		// TODO Auto-generated constructor stub
		type = EntityType.SPELL;
	}

}
