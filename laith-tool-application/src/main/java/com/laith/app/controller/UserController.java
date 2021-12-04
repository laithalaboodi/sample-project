package com.laith.app.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laith.app.dto.UserDTO;
import com.laith.app.model.User;
import com.laith.app.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/user")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
@CrossOrigin(origins="*")
public class UserController {
	
	private UserService uServ;
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
		
		//User u = new User(user.get("first"), user.get("last"), user.get("email"), user.get("pass"));
		
		User u = uServ.registerUser(userDTO);
		
		if(u != null) {
			
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<User>(u, HttpStatus.CONFLICT);
		}
	}//end of regester 
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> user){
		User u = uServ.loginUser(user.get("email"), user.get("pass"));
		
		
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		}

		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id")int id){
		User u = uServ.getUserById(id);
		
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<User>  updateBuyerCredentials(@RequestBody LinkedHashMap<String, String> user){
		
		User u = uServ.updateBuyer(  Integer.parseInt(user.get("id")) ,  user.get("newemail"), user.get("newpass"));
		
		if(u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

}
