package com.tyss.warehouse.boot.warehouse.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;

@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> IdNotFound(IdNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("id does not exists");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userNotFound(UserNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("user does not exists");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminAlreadyExists(UserIdnotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin user id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminAlreadyExists(AdminAlreadyExistsException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin already exists");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminnotFound(AdminIdNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin already exists");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<Object>> handleConstraintViolationException(javax.validation.ConstraintViolationException ex){
		List<String> errors = new ArrayList<>();
		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getMessage());
		}
		ResponseStructure<Object> structure = new ResponseStructure<>();
		structure.setData(errors);
		structure.setMessage("field validation exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ResponseStructure<Object>>(structure,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> list = ex.getAllErrors();
		HashMap<String,String> hashmap = new HashMap<>();
		for(ObjectError error:list) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			hashmap.put(fieldName, message);
		}
		
		return new ResponseEntity<Object>(hashmap,HttpStatus.BAD_REQUEST);
	}
	
	
}
