package com.naveen.service;

import java.util.ArrayList;
import java.util.List;

import com.naveen.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1=new Message(1L, "Hello world","Naveen");
		Message m2=new Message(2L, "Hello world1","agasthi");
		Message m3=new Message(3L, "Hello world2","aathi");
		Message m4=new Message(4L, "Hello world3","bharath");
		List< Message> list1=new ArrayList<Message>();
		list1.add(m1);
		list1.add(m2);
		list1.add(m3);
		list1.add(m4);
		return list1;
	}
	
}
