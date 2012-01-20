package com.twelvetwentyseven.regdar.common.quests;

import java.util.ArrayList;

import com.twelvetwentyseven.regdar.common.base.Location;
import com.twelvetwentyseven.regdar.common.entity.Item;

// Quest goal
public class Goal {
	private Location myLocation;
	private String description;
	private int kills;
	private ArrayList<Item> items;
	private boolean achieved;
}
