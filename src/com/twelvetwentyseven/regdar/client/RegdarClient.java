package com.twelvetwentyseven.regdar.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Listener.ThreadedListener;
import com.twelvetwentyseven.regdar.common.GameCharacter;
import com.twelvetwentyseven.regdar.common.Network;
import com.twelvetwentyseven.regdar.common.Network.addItem;
import com.twelvetwentyseven.regdar.common.Network.changeWeapon;
import com.twelvetwentyseven.regdar.common.Network.createAccount;
import com.twelvetwentyseven.regdar.common.Network.createCharacter;
import com.twelvetwentyseven.regdar.common.Network.createUser;
import com.twelvetwentyseven.regdar.common.Network.dropItem;
import com.twelvetwentyseven.regdar.common.Network.getActiveQuest;
import com.twelvetwentyseven.regdar.common.Network.getNumQuests;
import com.twelvetwentyseven.regdar.common.Network.getQuest;
import com.twelvetwentyseven.regdar.common.Network.heal;
import com.twelvetwentyseven.regdar.common.Network.login;
import com.twelvetwentyseven.regdar.common.Network.markHome;
import com.twelvetwentyseven.regdar.common.Network.perceptionCheck;
import com.twelvetwentyseven.regdar.common.Network.removeItem;
import com.twelvetwentyseven.regdar.common.Network.synchItems;
import com.twelvetwentyseven.regdar.common.Network.synchStats;
import com.twelvetwentyseven.regdar.common.Network.takeItem;
import com.twelvetwentyseven.regdar.common.Network.updateItems;
import com.twelvetwentyseven.regdar.common.Network.updateLocation;
import com.twelvetwentyseven.regdar.common.Network.updateStats;
import com.twelvetwentyseven.regdar.common.base.Location;
import com.twelvetwentyseven.regdar.common.entity.Item;
import com.twelvetwentyseven.regdar.common.entity.Weapon;
import com.twelvetwentyseven.regdar.common.quests.Quest;


// The game kicks this off
public class RegdarClient {

	public Client client;
	
	public RegdarClient() {
		Client client = new Client();
		client.start();
		
        // For consistency, the classes to be sent over the network are
        // registered by the same method for both the client and server.
        Network.register(client);

        // ThreadedListener runs the listener methods on a different thread.
        client.addListener(new ThreadedListener(new Listener() {
                public void connected (Connection connection) {
                }

                public void received (Connection connection, Object object) {
                        if (object instanceof login) {

                        }

                        if (object instanceof createCharacter) {

                                return;
                        }

                        if (object instanceof createAccount) {
                                return;
                        }
                        
                        if(object instanceof createUser) {
                        	return;
                        }

                        if (object instanceof perceptionCheck) {

                                return;
                        }
                        
                        if (object instanceof addItem) {
                        	return;
                        }
                        
                        if (object instanceof removeItem) {
                        	return;
                        }
                        if (object instanceof dropItem) {
                        	return;
                        }
                        
                        if (object instanceof updateLocation) {
                        	return;
                        }
                        
                        if (object instanceof getActiveQuest) {
                        	return;
                        }
                        
                        if (object instanceof getNumQuests) {
                        	return;
                        }
                        
                        
                        if (object instanceof getQuest) {
                        	return;
                        }
                        
                        if (object instanceof takeItem) {
                        	return;
                        }
                        
                        if (object instanceof updateItems) {
                        	return;
                        }
                        
                        if (object instanceof changeWeapon) {
                        	return;
                        }
                        
                        if (object instanceof markHome) {
                        	return;
                        }
                        
                        if (object instanceof heal) {
                        	return;
                        }
                        
                        if (object instanceof synchStats) {
                        	return;
                        }
                        
                        if (object instanceof synchItems) {
                        	return;
                        }
                        
                }

                public void disconnected (Connection connection) {
                        System.exit(0);
                }
        }));

	}
}
