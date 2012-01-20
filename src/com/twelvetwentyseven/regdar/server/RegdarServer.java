package com.twelvetwentyseven.regdar.server;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import com.twelvetwentyseven.regdar.common.Account;
import com.twelvetwentyseven.regdar.common.GameCharacter;
import com.twelvetwentyseven.regdar.common.Network;
import com.twelvetwentyseven.regdar.common.Network.ChatMessage;
import com.twelvetwentyseven.regdar.common.Network.RegisterName;
import com.twelvetwentyseven.regdar.common.Network.addItem;
import com.twelvetwentyseven.regdar.common.Network.changeWeapon;
import com.twelvetwentyseven.regdar.common.Network.createAccount;
import com.twelvetwentyseven.regdar.common.Network.createUser;
import com.twelvetwentyseven.regdar.common.Network.dropItem;
import com.twelvetwentyseven.regdar.common.Network.getActiveQuest;
import com.twelvetwentyseven.regdar.common.Network.getConnectedUsers;
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
import com.twelvetwentyseven.regdar.common.Network.UpdateNames;
import com.twelvetwentyseven.regdar.common.User;
import com.twelvetwentyseven.regdar.common.entity.Player;
import com.twelvetwentyseven.regdar.common.zone.Zone;
import com.twelvetwentyseven.regdar.server.accounts.AccountActions;

public class RegdarServer {
	
	Server server;
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Zone> zones = new ArrayList<Zone>();
	ArrayList<User> users = new ArrayList<User>();
	
	public RegdarServer() throws IOException {
        server = new Server() {
            protected Connection newConnection () {
                    // By providing our own connection implementation, we can store per
                    // connection state without a connection ID to state look up.
                    return new userConnection();
            }
        };
		

      // begin guts
    // For consistency, the classes to be sent over the network are
    // registered by the same method for both the client and server.
    // Runs through and checks each actions
    Network.register(server);

    server.addListener(new Listener() {
            public void received (Connection conn, Object object) {
                    // We know all connections for this server are actually CharacterConnections.
                    userConnection connection = (userConnection) conn;
                    //User user = connection.connectedUser;
                    

                    // Networking test functions

    				if (object instanceof RegisterName) {
    					// Ignore the object if a client has already registered a name. This is
    					// impossible with our client, but a hacker could send messages at any time.
    					if (connection.name != null) return;
    					// Ignore the object if the name is invalid.
    					String name = ((RegisterName)object).name;
    					if (name == null) return;
    					name = name.trim();
    					if (name.length() == 0) return;
    					// Store the name on the connection.
    					connection.name = name;
    					// Send a "connected" message to everyone except the new client.
    					ChatMessage chatMessage = new ChatMessage();
    					chatMessage.text = name + " connected.";
    					server.sendToAllExceptTCP(connection.getID(), chatMessage);
    					// Send everyone a new list of connection names.
    					updateNames();
    					return;
    				}

    				if (object instanceof ChatMessage) {
    					// Ignore the object if a client tries to chat before registering a name.
    					if (connection.name == null) return;
    					ChatMessage chatMessage = (ChatMessage)object;
    					// Ignore the object if the chat message is invalid.
    					String message = chatMessage.text;
    					if (message == null) return;
    					message = message.trim();
    					if (message.length() == 0) return;
    					// Prepend the connection's name and send to everyone.
    					chatMessage.text = connection.name + ": " + message;
    					server.sendToAllTCP(chatMessage);
    					return;
    				}
  
                    // End networking test functions
                    
                    if (object instanceof login) {
                    	// Login
                        login mLogin = (login)object;
                        AccountActions account = null;
						try {
							account = new AccountActions();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                        try {
							if (account.loginUser(mLogin) == null) {
							   	conn.close();
							   	return;
							  }
							   else {
							   	return;
							 }
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

                    }
                    
                    // Create Account
                    if (object instanceof createAccount) {
                    	// The user wants to create an account
                    	createAccount cAccount = (createAccount)object;
                    	Account newAccount = AccountActions.createUserAccount(cAccount.myUser);
                    }
                    
                    // Create User
                    if(object instanceof createUser) {
    					if (connection.name == null) return;
    					createUser newUser = (createUser)object;
    					// Create a new User
    					User createdUser = null;
    					// Need to figure out how to get rid of the try /catch here
						try {
							createdUser = new User();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    					try {
							createdUser.createUser(newUser.userName, newUser.userEmail, newUser.userPassword);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    					// Add the user
    					users.add(createdUser);
    					// Get ready to send it back
    					newUser.myUser = createdUser;
    					connection.connectedUser = createdUser;
    					
    					ChatMessage chatMessage = new ChatMessage();
    					chatMessage.text= connection.name + ":id: " + connection.getID() + " :user: " + newUser.userName + " Done;";
    					
    					server.sendToTCP(newUser.connectionID, chatMessage);
    					return;
                    }
                    
                    if(object instanceof getConnectedUsers){
                    	getConnectedUsers numUsers = (getConnectedUsers)object;
                    	numUsers.numConnections = users.size();
                    	String userList = "";
                    	for(User u: users){
                    		userList = userList + u.userName + " ";
                    	}
                    	numUsers.connectedUsers = userList;
                    	ChatMessage chatMessage  = new ChatMessage();
                    	chatMessage.text = numUsers.connectedUsers;
                    	
                    	server.sendToTCP(numUsers.connectionID, chatMessage);
                    	
                    }
					
					
                    if (object instanceof perceptionCheck) {
                    	GameCharacter gameChar = (GameCharacter)object;
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

            private boolean isValid (String value) {
                    if (value == null) return false;
                    value = value.trim();
                    if (value.length() == 0) return false;
                    return true;
            }

            public void disconnected (Connection conn) {
            	// if disconnected - just mark the player as inactive
                    userConnection connection = (userConnection) conn;
                    if (connection.connectedUser != null) {
                            //loggedIn.remove(connection.character);

                            //RemoveCharacter removeCharacter = new RemoveCharacter();
                            //removeCharacter.id = connection.character.id;
                            //server.sendToAllTCP(removeCharacter);
                    }
            }
    });
    server.bind(Network.port);
    server.start();
    
    // Open a window - just for debugging now
	// Open a window to provide an easy way to stop the server.
	JFrame frame = new JFrame("Chat Server");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosed (WindowEvent evt) {
			server.stop();
		}
	});
	frame.getContentPane().add(new JLabel("Close to stop the chat server."));
	frame.setSize(320, 200);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}

	// Log the user in - and all it entails - will move to a new class
    void loggedIn (userConnection conn, User myUser) {
    	// This just adds the player to the arraylist of players - need
    	// to put this somewhere else so I can sort player by zones
        conn.connectedUser = myUser;

        // Need to get a player - don't know yet if I'm using player or user for this
        Player myPlayer = null;
        
        // Add existing characters to new logged in connection.
        for( Player play : players){
        	// Add the new character
        	// send to all characters - there is a new player - don't need this
        	// Need to just store the player in the zone with location
        }
        players.add(myPlayer);

        // Add logged in character to all connections.
        /*
        AddCharacter addCharacter = new AddCharacter();
        addCharacter.character = character;
        */
}
    
// End guts
	
	
    // This holds per connection state - should be moved to another class
	// Are we holding Account - User - or Character as the connection?
	//User for right now
    static class userConnection extends Connection {
            public User connectedUser;
            public String name;
    }
    
    // For networking test
	void updateNames () {
		// Collect the names for each connection.
		Connection[] connections = server.getConnections();
		ArrayList names = new ArrayList(connections.length);
		for (int i = connections.length - 1; i >= 0; i--) {
			userConnection connection = (userConnection)connections[i];
			names.add(connection.name);
		}
		// Send the names to everyone.
		UpdateNames updateNames = new UpdateNames();
		updateNames.names = (String[])names.toArray(new String[names.size()]);
		server.sendToAllTCP(updateNames);
	}
    
	public static void main (String[] args) throws IOException {
		Log.set(Log.LEVEL_DEBUG);
		new RegdarServer();
	}


	}
