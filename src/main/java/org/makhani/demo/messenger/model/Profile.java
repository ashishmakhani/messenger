package org.makhani.demo.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	
	private String profilename;
	private long id;
	private String firstname;
	private String lastname;
    
public Profile() {
    	
    }

public Profile(String profilename,long id, String firstname, String lastname) {
	super();
	this.profilename = profilename;
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
}

public String getProfilename() {
	return profilename;
}

public void setProfilename(String profilename) {
	this.profilename = profilename;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

}
