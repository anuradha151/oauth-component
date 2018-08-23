package com.anuradha.demo.exception.mapper;

import com.anuradha.demo.model.ErrorMessageModel;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.MissingFormatArgumentException;

public class MissingRequiredFieldExceptionMapper implements ExceptionMapper<MissingFormatArgumentException> {
    @Override
    public Response toResponse(MissingFormatArgumentException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessageModel(exception.getMessage(), exception.getStackTrace()[0].getClassName(), exception.getStackTrace()[0].getLineNumber())).build();

    }
}
