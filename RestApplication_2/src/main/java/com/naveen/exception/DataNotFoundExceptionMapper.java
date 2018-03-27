package com.naveen.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.naveen.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errormessage=new ErrorMessage(ex.getMessage(), 404, "http://com.naveen");
		  return Response.status(Status.NOT_FOUND)
			.entity(errormessage)
		    .type(MediaType.APPLICATION_JSON)
		    .build();
	}

}
