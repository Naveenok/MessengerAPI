package com.naveen.src;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResources {
@GET 
public String test(){
	return "new sub reources";
}
@GET
@Path("/{commentid}")
public String test1(@PathParam ("commentid") Long id,@PathParam("messageId") Long id1){
	return "commentid : " + id +" for "+ id1;
}
}
