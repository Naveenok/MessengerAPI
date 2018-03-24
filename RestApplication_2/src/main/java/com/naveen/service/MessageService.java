package com.naveen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naveen.database.DatabaseClass;
import com.naveen.model.Message;

public class MessageService {
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	public  MessageService(){
		messages.put(1L, new Message(1, "HelloWorld", "Naveen"));
		messages.put(2L, new Message(2, "HelloWorld1", "Bharath"));
		messages.put(3L, new Message(3, "HelloWorld2", "Agasthi"));
		messages.put(4L, new Message(4, "HelloWorld3", "Aathi"));
	}

	public List<Message> getAllMessages() {
		/*Message m1=new Message(1L, "Hello world","Naveen");
		Message m2=new Message(2L, "Hello world1","agasthi");
		Message m3=new Message(3L, "Hello world2","aathi");
		Message m4=new Message(4L, "Hello world3","bharath");
		List< Message> list1=new ArrayList<Message>();
		list1.add(m1);
		list1.add(m2);
		list1.add(m3);
		list1.add(m4);*/
		return new ArrayList<Message>( messages.values());
	}
	public Message getMessage(Long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
				}
	public Message updateMessage(Message message){
		Long id=message.getId();
		if (id<=0) {
			return null;
		}
		messages.put(id, message);
		return message;
	}
	
	public Message removeMessage(Long id){  
		return messages.remove(id);
	
	}
	
	
}
