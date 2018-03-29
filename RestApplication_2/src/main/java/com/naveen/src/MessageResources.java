package com.naveen.src;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

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
	//@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	@Produces(MediaType.APPLICATION_JSON)
 public List<Message> getJsonMessages(){
	 return messageser.getAllMessages();
	 //returning a List of messages 
	 
 }
	@GET
	//@Produces(value={MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	@Produces(MediaType.APPLICATION_XML)
 public List<Message> getXmlMessages(){
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
	//response returned along with the message
	/*public Response addMessage(Message message){
		Message newmessage= messageser.addMessage(message);
		return Response.status(Status.CREATED)
				.entity(newmessage)
				.build();//build the response instance
		OR the below one which returns with (Location)Uri as well*/
		
		public Response addMessage(Message message,@Context UriInfo uriInfo ){
			Message newmessage= messageser.addMessage(message);
			String newId=String.valueOf(newmessage.getId());
			URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
			return Response.created(uri) 
					.entity(newmessage)
					.build();//build the response instance
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
	@Path("/{messageId}/comments")
	public CommentResources getCommentResource(){
		return new CommentResources();
	}
	
}
   
