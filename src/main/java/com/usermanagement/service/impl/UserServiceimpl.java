package com.usermanagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.entity.UserDetails;
import com.usermanagement.repo.UserRepository;
import com.usermanagement.service.IUserService;

@Service
public class UserServiceimpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails addUser(UserDetails userDetails) {
		UserDetails save = userRepository.save(userDetails);
		return save;
	}

	@Override
	public UserDetails getUSerById(int id) throws Exception {
		UserDetails findById = userRepository.findById(id)
				.orElseThrow(()-> new Exception("User Does Not exist by id : "+id));
		return findById;
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails, int uid) {
		UserDetails findById = userRepository.findById(uid).get();
		findById.setEmail(userDetails.getEmail());
		findById.setPassword(userDetails.getPassword());
		findById.setPhoneNo(userDetails.getPhoneNo());
		findById.setUserName(userDetails.getUserName());
		UserDetails save = userRepository.save(findById);

		
		return save;
	}

	@Override
	public String deleteUserById(int uid) {
		UserDetails findById = userRepository.findById(uid).get();
		userRepository.delete(findById);
		return "User deleted successfully";
	}

}
