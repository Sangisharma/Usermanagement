package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.entity.UserDetails;
import com.usermanagement.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService iUserService;

	@PostMapping(value = "/add")
	public UserDetails addUser(@RequestBody UserDetails userDetails) {
		UserDetails u = iUserService.addUser(userDetails);
		return u;
	}

	@GetMapping("/findById/{id}")
	public UserDetails getUser(@PathVariable int id) throws Exception {
		UserDetails userById = iUserService.getUSerById(id);
		return userById;
	}
	@PutMapping(value = "/updateById/{id}")
	public UserDetails updateUser(@RequestBody UserDetails userDetails,@PathVariable int id) {
		UserDetails u = iUserService.updateUser(userDetails,id);
		return u;
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteUser(@PathVariable int id) {
		String userById = iUserService.deleteUserById(id);
		return userById;
	}
}

