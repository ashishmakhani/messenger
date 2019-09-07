package org.makhani.demo.messenger.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.makhani.demo.messenger.model.Comment;
import org.makhani.demo.messenger.service.Commentservice;

public class Commentresource {
	
	private Commentservice commentservice = new Commentservice(); 

	@GET
	public List<Comment>getallcomments(@PathParam("messageid")long messageid){
		return commentservice.getallComments(messageid);
	}
	
	@POST
	public Comment addcomment(@PathParam("messageid")long messageid, Comment Comment) {
    	return commentservice.addComment(messageid,Comment);
    }
	
	@PUT
	@Path("/{commentid}")
	public Comment updatecomment(@PathParam("messageid")long messageid, @PathParam("commentid")long id, Comment Comment) {
    	
		Comment.setId(id);
		return commentservice.updateComment(messageid,Comment);
    }
	
	@DELETE
	@Path("/{commentid}")
	public void deletecomment(@PathParam("messageid")long messageid, @PathParam("commentid")long commentid) {
    	
	 commentservice.removeComment(messageid,commentid);
    }
	
	@GET
	@Path("/{commentid}")
	public Comment getcomment(@PathParam("messageid")long messageid, @PathParam("commentid")long commentid) {
    	
	 return commentservice.getComment(messageid,commentid);
	}
}
