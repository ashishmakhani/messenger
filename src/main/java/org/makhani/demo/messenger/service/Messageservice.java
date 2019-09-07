package org.makhani.demo.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.makhani.demo.messenger.database.Database;
import org.makhani.demo.messenger.model.Message;

public class Messageservice {
	
	private static Map<Long,Message> message = Database.getmessage();
	
	public Messageservice() {
		message.put(1L,new Message(1,"Hello Ashish Makhani","Ashish"));
		message.put(2L,new Message(2,"Hello Jack ma","Ashish"));
	}
	
	public static List<Message>getallmsg() {
		
		return new ArrayList<Message>(message.values());
	}
	
	public static List<Message>getallmsgforyear(int year){
		
		List<Message>messageforyear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		
		for(Message msg: message.values()) {
			cal.setTime(msg.getCreated());
		if(cal.get(Calendar.YEAR)== year) {
			messageforyear.add(msg);
		}
		}
		return messageforyear;
	}
	
public static List<Message>getallmsgpaginated(int start, int size){
		
		ArrayList<Message>list = new ArrayList<Message>(message.values());
		if (start +size > list.size())
			return new ArrayList<Message>();
		return list.subList(start,start+size);
}
	
	public static Message getmessage(Long id)
	{
		return message.get(id);
	}
	public static Message addmessage(Message messages) {
		
		messages.setId(message.size()+1);
		message.put(messages.getId(),messages);
		return messages;
	}
	public static Message updatemessage(Message messages) {
		if (messages.getId()<=0) {
			return null;
		}
	message.put(messages.getId(), messages);
		return messages;
	}
	
	public static Message removemessage(Long id) {
		return message.remove(id);
	}
}

