package org.makhani.demo.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.makhani.demo.messenger.model.Profile;
import org.makhani.demo.messenger.service.Profileservice;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Profileresource {
	
	private Profileservice profileservice = new Profileservice();
	
	@GET
	public List<Profile>getprofile(){
    	return profileservice.getallprofile();
    }
	
	@GET
    @Path("/{profilename}")
    public Profile getprofile(@PathParam("profilename")String profilename) {
    	return profileservice.getprofile(profilename);
    }
	
	@POST
	public Profile addprofile(Profile profiles) {
    	return profileservice.addprofile(profiles);
    }
	
	@PUT
    @Path("/{profilename}")
	public Profile updateProfile(@PathParam("profilename")String profilename, Profile profile) {
    	profile.setProfilename(profilename);
    	return profileservice.updateprofile(profile);
    }

	@DELETE
    @Path("/{profilename}")
    public void deleteprofile(@PathParam("profilename")String profilename) {
    	profileservice.removeprofile(profilename);	
}
}