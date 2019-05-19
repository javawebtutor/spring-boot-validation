package com.jwt.validation.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.validation.demo.entity.User;
import com.jwt.validation.demo.model.UserRequest;
import com.jwt.validation.demo.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/createuser")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		User user = new User();
		user.setFirstNane(userRequest.getFirstNane());
		user.setMiddleName(userRequest.getMiddleName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setDateOfBirth(userRequest.getDateOfBirth());
		User savedUser = userRepository.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/getalluser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return new ResponseEntity<List<User>>(findAll, HttpStatus.OK);
	}
	
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Map<String, String>>
	 * handleValidationExceptions(MethodArgumentNotValidException ex) { Map<String,
	 * String> errorMap = new HashMap<>(); List<ObjectError> errors =
	 * ex.getBindingResult().getAllErrors(); for (ObjectError error : errors) {
	 * String fieldName = ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errorMap.put(fieldName, errorMessage); } return
	 * new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */

}
