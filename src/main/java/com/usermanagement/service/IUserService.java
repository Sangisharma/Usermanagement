package com.usermanagement.service;

import com.usermanagement.entity.UserDetails;

public interface IUserService {
	UserDetails addUser(UserDetails userDetails);
	UserDetails getUSerById(int id) throws Exception;
	UserDetails updateUser(UserDetails userDetails,int uid);
	String deleteUserById(int uid);

	


}
