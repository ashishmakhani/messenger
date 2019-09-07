package org.makhani.demo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.makhani.demo.messenger.database.Database;
import org.makhani.demo.messenger.model.Comment;
import org.makhani.demo.messenger.model.Message;

public class Commentservice {
	
	private static Map<Long,Message> message = Database.getmessage();
	
    public List<Comment>getallComments(Long messageid) {
		
	   Map<Long, Comment> comments = message.get(messageid).getComments();
		
	   return new ArrayList<Comment>(comments.values());
	}
   
    public Comment getComment(Long messageid, Long commentid)
	{
		
    	Map<Long, Comment> comments = message.get(messageid).getComments();
    	return comments.get(commentid);
	}
    
    public Comment addComment(Long Messageid, Comment comment) {
		
    	Map<Long, Comment> comments = message.get(Messageid).getComments();
    	comment.setId(comments.size()+1);
    	comments.put(comment.getId(),comment);
		return comment;
	}
    
    public Comment updateComment(Long messageid, Comment comment) {
    	
    	Map<Long, Comment> comments = message.get(messageid).getComments();
    	
    	if (comment.getId()<=0) {
			return null;
		}
	comments.put(comment.getId(), comment);
		return comment;
	}

    public Comment removeComment(Long messageid, Long commentid) {
		
    	Map<Long, Comment> comments = message.get(messageid).getComments();
    	return comments.remove(commentid);
	}
}
