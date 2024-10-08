package com.usermanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.entity.UserDetails;
import com.usermanagement.exceptions.ResourceNotFoundException;
import com.usermanagement.repo.UserRepository;
import com.usermanagement.service.IUserService;

@Service
public class UserServiceimpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails addUser(UserDetails userDetails) throws Exception {
		UserDetails user = userRepository.findUserByPhoneNo(userDetails.getPhoneNo());
		if (user == null) {
			return userRepository.save(userDetails);
		} else {
			throw new Exception("User Already exist In the application");
		}

	}

	@Override
	public UserDetails getUSerById(int id) throws ResourceNotFoundException {
		UserDetails u = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Does Not exist by id : " + id));
		return u;
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails, int uid) throws ResourceNotFoundException {
		UserDetails findById = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User Does Not exist by id : " + uid));
		findById.setEmail(userDetails.getEmail());
		findById.setPassword(userDetails.getPassword());
		findById.setPhoneNo(userDetails.getPhoneNo());
		findById.setUserName(userDetails.getUserName());
		UserDetails save = userRepository.save(findById);

		return save;
	}

	@Override
	public String deleteUserById(int uid) throws ResourceNotFoundException {
		UserDetails u = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User Does Not exist by id : " + uid));
		userRepository.delete(u);
		return "User deleted successfully";
	}

	@Override
	public List<UserDetails> getAllUserDetails() {

//		List<UserDetails> list = userRepository.findAll().stream().sorted().collect(Collectors.toList());

		return userRepository.getAllUsers();
	}

}
