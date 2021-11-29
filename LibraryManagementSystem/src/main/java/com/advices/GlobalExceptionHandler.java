package com.advices;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class) 
	public ResponseEntity<?>booknotfoundexception(BookNotFoundException ex, WebRequest request)
   {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
   }
	  
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<?> authornotfoundexception(AuthorNotFoundException ex, WebRequest request) 
	{
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(AddressNotFoundException.class) 
	public ResponseEntity<?> addressnotfoundexception(AddressNotFoundException ex, WebRequest request)
	{ 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		return new  ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(IDNotFoundException.class) 
	public ResponseEntity<?> idNotFoundException(IDNotFoundException ex, WebRequest request)
   {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
   }
	  
	  @ExceptionHandler(OrderNotFoundException.class) 
	  public ResponseEntity<?>handleordernotfoundexception(OrderNotFoundException ex, WebRequest request) 
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	 
	  @ExceptionHandler(ReaderNotFoundException.class) 
	  public ResponseEntity<?>handlereadernotfoundexception(ReaderNotFoundException ex, WebRequest request)
	  {
		  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	  @ExceptionHandler(UserNotFoundException.class) 
	  public ResponseEntity<?> handleusernotfoundexception(UserNotFoundException ex, WebRequest request)
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	  
	  @ExceptionHandler(PublisherNotFoundException.class) 
	  public ResponseEntity<?> handlepublishernotfoundexception(PublisherNotFoundException ex, WebRequest request)
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	  
	  @ExceptionHandler(InvalidCredentialsException.class) 
	  public ResponseEntity<?> handleinvalidcredentialsexception(InvalidCredentialsException ex, WebRequest request)
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	  
	  @ExceptionHandler(UserFoundException.class) 
	  public ResponseEntity<?> handleuserfoundexception(UserFoundException ex, WebRequest request)
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	  
	  @ExceptionHandler(Exception.class)
		public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request)
		{
			ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	 
}