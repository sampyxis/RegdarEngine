package com.twelvetwentyseven.regdar.common.entity;

import com.twelvetwentyseven.regdar.common.base.EntityType;
import com.twelvetwentyseven.regdar.common.base.Location;

public class Money extends Item {

	public Money(Location myLocation, int amount) {
		super(myLocation);
		// TODO Auto-generated constructor stub
		type = EntityType.MONEY;
		// Set the money when I create it
		money = amount;
	}

}
