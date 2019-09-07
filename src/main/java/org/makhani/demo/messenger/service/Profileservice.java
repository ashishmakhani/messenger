package org.makhani.demo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.makhani.demo.messenger.database.Database;
import org.makhani.demo.messenger.model.Profile;

public class Profileservice {
	private static Map<String, Profile> profile= Database.getprofile();

	public Profileservice() {
		profile.put("Ashish",new Profile("muskan",1,"Muskan","Makhani"));
		profile.put("Ashish",new Profile("James",2,"Jack","Ma"));
	}
	
public List<Profile>getallprofile() {
		
		return new ArrayList<Profile>(profile.values());
	}
	public Profile getprofile(String profilename)
	{
		return profile.get(profilename);
	}
	public Profile addprofile(Profile profiles) {
		
		profiles.setId(profile.size()+1);
		profile.put(profiles.getProfilename(),profiles);
		return profiles;
	}
	public Profile updateprofile(Profile profiles) {
		if (profiles.getProfilename().isEmpty()) {
			return null;
		}
		profile.put(profiles.getProfilename(), profiles);
		return profiles;
	}
	
	public Profile removeprofile(String Profilename) {
		return profile.remove(Profilename);
	}
}