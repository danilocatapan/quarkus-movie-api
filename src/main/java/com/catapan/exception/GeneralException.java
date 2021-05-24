package com.catapan.exception;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {

    MessageError messageError = new MessageError();

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception exception) {

        if (exception instanceof BusinessException) {
            messageError.setMessage(exception.getMessage());
            return Response.status(Status.BAD_REQUEST).entity(messageError).build();
        }

        messageError.setMessage("Por favor entre em contao com o suporte");
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(messageError).build();
    }
}
