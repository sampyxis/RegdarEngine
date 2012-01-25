package com.twelvetwentyseven.regdar.common;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.twelvetwentyseven.regdar.common.base.Location;
import com.twelvetwentyseven.regdar.common.entity.Item;
import com.twelvetwentyseven.regdar.common.entity.Mob;
import com.twelvetwentyseven.regdar.common.entity.Weapon;
import com.twelvetwentyseven.regdar.common.quests.Quest;

//This class is a convenient place to keep things common to both the client and server.
public class Network {
     static public final int port = 54555;

     // This registers objects that are going to be sent over the network.
     // These should be what my actions are
     // So, each side will have these
     static public void register (EndPoint endPoint) {
             Kryo kryo = endPoint.getKryo();
             kryo.register(passString.class);
             kryo.register(login.class);
             kryo.register(createCharacter.class);
             kryo.register(userCharacter.class);
             kryo.register(createAccount.class);
             kryo.register(createUser.class);
             kryo.register(getConnectedUsers.class);
             kryo.register(perceptionCheck.class);
             kryo.register(updateStats.class);
             kryo.register(updateItems.class);
             kryo.register(addItem.class);
             kryo.register(removeItem.class);
             kryo.register(dropItem.class);
             kryo.register(updateLocation.class);
             kryo.register(getActiveQuest.class);
             kryo.register(getNumQuests.class);
             kryo.register(takeItem.class);
             kryo.register(attack.class);
             kryo.register(changeWeapon.class);
             kryo.register(markHome.class);
             kryo.register(synchItems.class);
             kryo.register(synchStats.class);
             kryo.register(heal.class);
             //Networking tests
    		 kryo.register(RegisterName.class);
    		 kryo.register(String[].class);
    		 kryo.register(UpdateNames.class);
    		 kryo.register(ChatMessage.class);

     }
     
     // Use one class for now to pass in the strings
     static public class passString {
    	 public String passedString;
    	 public int connectedID;
     }
     static public class login {
    	 public int connectedID;
    	 public String name;
    	 public String email;
    	 public String password;
     }
     
     static public class createCharacter {
    	 public User myUser;
    	 public GameCharacter myChar;
     }
     
     static public class userCharacter {
    	 public User myUser;
    	 public GameCharacter myChar;
     }

     // Remove
     static public class createAccount {
    	 public User myUser;
    	 public Account myAccount;
     }
     
     static public class createUser {
    	 public int connectionID;
    	 public User myUser;
    	 public String userName;
    	 public String userEmail;
    	 public String userPassword;
     }
     
     static public class getConnectedUsers {
    	 public int connectionID;
    	 public int numConnections;
    	 public String connectedUsers;
     }
     
     static public class perceptionCheck {
    	 public GameCharacter myChar;
     }
     
     static public class updateStats {
    	 public GameCharacter myChar;
     }
     
     static public class updateItems {
    	 public GameCharacter myChar;
     }
     
     static public class addItem {
    	 public GameCharacter myChar;
    	 public Item myItem;
     }
     
     static public class removeItem {
    	 public GameCharacter myChar;
    	 public Item myItem;
     }
     
     static public class dropItem {
    	 public GameCharacter myChar;
    	 public Item myItem;
     }
     

     static public class updateLocation {
    	 public GameCharacter myChar;
    	 public Location myLocation;
     }
     
     static public class getActiveQuest {
    	 public GameCharacter myChar;
    	 public Quest myQuest;
     }
     
     static public class  getNumQuests {
    	 public GameCharacter myChar;
     }
     
     static public class getQuest {
    	 public GameCharacter myChar;
    	 public Location myLocation;
    	 public Quest myQuest;
     }
     
     static public class takeItem {
    	 public GameCharacter myChar;
    	 public Item myItem;
     }
     
     static public class attack {
    	 public GameCharacter myChar;
    	 public GameCharacter otherChar;
     }
     
     static public class changeWeapon {
    	 public GameCharacter myChar;
    	 public Weapon myWeapon;
     }
     
     static public class markHome {
    	 public GameCharacter myChar;
    	 public Location myLocation;
     }
     
     static public class synchItems {
    	 public GameCharacter myChar;
     }
     
     static public class synchStats {
    	 public GameCharacter myChar;
    	 
     }
     
     static public class heal {
    	 public GameCharacter myChar;
    	 // I think this needs to be Mob
    	 // Can heal self - or any other Player / NPC nearby
    	 public Mob toHeal;
     }
     
     //Networking test code

 	static public class RegisterName {
 		public String name;
 	}

 	static public class UpdateNames {
 		public String[] names;
 	}

 	static public class ChatMessage {
 		public String text;
 	}
     

}