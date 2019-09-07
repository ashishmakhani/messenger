package org.makhani.demo.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.makhani.demo.messenger.bean.Messagefilterbean;
import org.makhani.demo.messenger.model.Message;
import org.makhani.demo.messenger.service.Messageservice;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Messageresource {

	Messageservice messageservice = new Messageservice();
    
	@GET
    public List<Message>getallmsg(@QueryParam("year") int year,
    							   @QueryParam("start")int start,
    							   @QueryParam("size") int size,
    							   @BeanParam Messagefilterbean filterbean){
    	if (filterbean.getYear() > 0) {
    		return Messageservice.getallmsgforyear(year);
    	}
    	if(filterbean.getStart() >= 0 && filterbean.getSize() >= 0) {
    		return Messageservice.getallmsgpaginated(start,size);	
    	}
    	return Messageservice.getallmsg();
    }
    
    @POST
    public Message addmessage(Message msg) {
    	return Messageservice.addmessage(msg);
    }
    
    @PUT
    @Path("/{messageid}")
    public Message updatemessage(@PathParam("messageid")long id, Message msg) {
    	msg.setId(id);
    	return Messageservice.updatemessage(msg);
    }
    
    @DELETE
    @Path("/{messageid}")
    public void deletemessage(@PathParam("messageid")long id) {
    	Messageservice.removemessage(id);
    }
    
    @GET
    @Path("/{messageid}")
    public Message getmessage(@PathParam("messageid")long id) {
    	return Messageservice.getmessage(id);
    }
    
    @Path("/{messageid}/comments")
    public Commentresource getcommentresource() {
    	return new Commentresource();
    }
}
