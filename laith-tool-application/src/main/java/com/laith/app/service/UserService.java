package com.laith.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laith.app.dao.UserRepo;
import com.laith.app.dto.UserDTO;
import com.laith.app.model.User;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class UserService {
	
	private UserRepo uDao;
	
	public User registerUser(UserDTO userDTO) {
		User u = null;
		UserDTO uNoargsDTO = new UserDTO();
		UserDTO uAllNoargsDTO = new UserDTO("f","l","e","p");
		u = new User(0, userDTO.getFirst(), userDTO.getLast(), userDTO.getEmail(), userDTO.getPass());
		
		try {
			uDao.save(u);
			return u;
		} catch(Exception e) {
			return null;
		}
	}
	
public User loginUser(String email, String password) {
		//findByUsername will return null if the user does not exist
		User u = uDao.findByEmail(email);
		//If username does not exist return null
		if(u == null) {
			return null;
		}
		else {
			//If you user exists but password is wrong return null
			if(!u.getPass().equals(password)) {
				return null;
			}
			//Else return the logged in user
			else {
				return u;
			}
		}
	}

public User displayUser(String email) {
	User u = uDao.findByEmail(email);
		if(u == null) {
			return null;
		}
		else {
			return u;
		}
	}

	public User getUserById(int id) {
		return uDao.findById(id);
	}
	
	
	public User updateBuyer(int buyerid, String newemail, String newpass) {
		User user = uDao.findById(buyerid);
		    // crush the variables of the object found
		  if (user ==null) {
			return null;
		} else {

			if (!newemail.equals("")) {
				
				user.setEmail(newemail);
			}
			
			if (!newpass.equals("")) {
				
				user.setPass(newpass);
		}
				 		   
			  return  uDao.save(user);
		
		}
		   
		}
	
}
