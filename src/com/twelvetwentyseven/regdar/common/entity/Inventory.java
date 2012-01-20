package com.twelvetwentyseven.regdar.common.entity;

import java.util.ArrayList;

public class Inventory extends ArrayList<Item> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2741474851287412388L;

	public Inventory(){
		
	}

	public void addItem(Item newItem){
		this.add(newItem);
	}
	
	public void removeItem(Item remItem){
		this.remove(remItem);
	}
}
