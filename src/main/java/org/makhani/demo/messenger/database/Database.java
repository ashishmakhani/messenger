package org.makhani.demo.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.makhani.demo.messenger.model.Message;
import org.makhani.demo.messenger.model.Profile;

public class Database {
	
	private static Map<Long, Message> message = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();

	public static Map<Long, Message> getmessage(){
		return message;
	}
	public static Map<String, Profile> getprofile(){
			return profile;
	
	}
}
