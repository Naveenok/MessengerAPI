package com.naveen.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.naveen.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errormessage=new ErrorMessage(ex.getMessage(), 404, "http://com.naveen");
		  return Response.status(Status.INTERNAL_SERVER_ERROR)
			.entity(errormessage)
		    .type(MediaType.APPLICATION_JSON)
		    .build();	
	}

}
