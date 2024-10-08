package com.usermanagement.service;

import java.util.List;

import com.usermanagement.entity.UserDetails;
import com.usermanagement.exceptions.ResourceNotFoundException;

public interface IUserService {
	UserDetails addUser(UserDetails userDetails) throws Exception;

	UserDetails getUSerById(int id) throws ResourceNotFoundException;

	UserDetails updateUser(UserDetails userDetails, int uid) throws ResourceNotFoundException;

	String deleteUserById(int uid) throws ResourceNotFoundException;
	
	List<UserDetails> getAllUserDetails();

}
