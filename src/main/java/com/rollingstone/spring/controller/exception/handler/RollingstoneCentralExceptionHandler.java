package com.rollingstone.spring.controller.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rollingstone.exceptions.HTTP400Exception;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.exceptions.RestAPIExceptionInfo;

//@ControllerAdvice
//@RestController
public class RollingstoneCentralExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<RestAPIExceptionInfo> handleAllExceptions(Exception ex, WebRequest request) {
		 RestAPIExceptionInfo exceptionResponse = new RestAPIExceptionInfo(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(HTTP400Exception.class)
	  public final ResponseEntity<RestAPIExceptionInfo> handleUserNotFoundException(HTTP400Exception ex, WebRequest request) {
		  RestAPIExceptionInfo exceptionResponse = new RestAPIExceptionInfo(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(HTTP404Exception.class)
	  public final ResponseEntity<RestAPIExceptionInfo> handleUserNotFoundException(HTTP404Exception ex, WebRequest request) {
		  RestAPIExceptionInfo exceptionResponse = new RestAPIExceptionInfo(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
}
