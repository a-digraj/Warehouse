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
	public ResponseEntity<ResponseStructure<String>> adminAlreadyExists(WarehouseAlreadyExistException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("warehouse already exists");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> warehouseAlreadyExists(AdminAlreadyExistsException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin already exists");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> userAlreadyExists(UserAlreadyExistsException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("user already exists");
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> findUserByName(UserCredentialsInvalid ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("user credentials invalid");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> findGroceryByName(GroceryNotFoundByName ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("grocery with name not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> NoGroceryFound(NoGroceryFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("groceries not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	
	public ResponseEntity<ResponseStructure<String>> findProcessedGoodByByName(ProcessedGoodNotFoundByName ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("ProcessedGood with name not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ProcessedGoodsNotFound(ProcessedGoodsNotFound ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("ProcessedGoods not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminnotFound(AdminIdNotFoundException ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("admin not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> groceryAlreadyPresent(GroceryAlreadyPresent ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("grocery already exists");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
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
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> invalidCredentials(AdminCredentialsNotValid ex){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ex.getMessage());
		structure.setMessage("Admin credentials wrong");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
