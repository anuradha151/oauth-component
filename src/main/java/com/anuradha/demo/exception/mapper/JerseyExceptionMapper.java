package com.anuradha.demo.exception.mapper;

import com.anuradha.demo.exception.JerseyException;
import com.anuradha.demo.model.ErrorMessageModel;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class JerseyExceptionMapper  implements ExceptionMapper<JerseyException> {
    @Override
    public Response toResponse(JerseyException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessageModel(e.getMessage(), e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getLineNumber())).build();
    }
}
