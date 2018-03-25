package com.naveen.src;

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

import com.naveen.model.Message;
import com.naveen.service.MessageService;

@Path("/messages")
//if all the methods uses produces or consumes then we can put a common produces & consumes at class level
//like below one
/*@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)*/
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
	@PUT
	@Path("/test/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageid")Long id,Message message){
		message.setId(id);
		return messageser.updateMessage(message);
	}
	 
	@DELETE 
	@Path("/test/{mesid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("mesid") Long id){
		 messageser.removeMessage(id);
	}
	
}
   
