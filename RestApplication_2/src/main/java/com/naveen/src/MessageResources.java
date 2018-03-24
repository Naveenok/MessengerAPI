package com.naveen.src;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.naveen.model.Message;
import com.naveen.service.MessageService;

@Path("/messages")
public class MessageResources {
	MessageService messageser=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
 public List<Message> getMessages(){
	 return messageser.getAllMessages();
	 //returning a List of messages 
 }
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test/{id}")
	public Message getMessage(@PathParam("id")  Long id){
		return messageser.getMessage(id);
	}
	@POST
	/*@Path("/addmessage")*/
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageser.addMessage(message);
	}

	
	
	
	
	
}
   
