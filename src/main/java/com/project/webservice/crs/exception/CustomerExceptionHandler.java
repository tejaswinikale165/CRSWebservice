package com.project.webservice.crs.exception;

import com.project.webservice.crs.exception.custom.BadRequestException;
import com.project.webservice.crs.exception.custom.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request){
        HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
        String message="Problem occured during handling your request";
        if(ex instanceof BadRequestException)
        {
            status=HttpStatus.BAD_REQUEST;
            message = ex.getMessage();
        }

        else if(ex instanceof NotFoundException)
        {
            status=HttpStatus.NOT_FOUND;
            message = ex.getMessage();
        }

        ErrorResponse errorResponse=new ErrorResponse(status,message);
return new ResponseEntity<>(errorResponse, status);
    }
}
