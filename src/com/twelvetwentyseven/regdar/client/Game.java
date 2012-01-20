package com.twelvetwentyseven.regdar.client;

import java.io.IOException;

import com.esotericsoftware.minlog.Log;


// 
public class Game {

	public RegdarClient client;
	
	public Game(){
		// When we start the game - create the client
		RegdarClient client = new RegdarClient();
		
	}
	
	public static void main (String[] args) throws IOException {
		Log.set(Log.LEVEL_DEBUG);
		new Game();
	}
}
