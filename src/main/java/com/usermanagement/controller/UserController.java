package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.entity.UserDetails;
import com.usermanagement.exceptions.ResourceNotFoundException;
import com.usermanagement.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping(value = "/add")
	public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails userDetails) throws Exception {

		UserDetails u = iUserService.addUser(userDetails);

		return new ResponseEntity<UserDetails>(u, HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<UserDetails> getUser(@PathVariable int id) throws ResourceNotFoundException {

		UserDetails u = iUserService.getUSerById(id);

		return ResponseEntity.ok(u);
	}

	@PutMapping(value = "/updateById/{id}")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails, @PathVariable int id)
			throws ResourceNotFoundException {

		UserDetails u = iUserService.updateUser(userDetails, id);

		return ResponseEntity.ok(u);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) throws ResourceNotFoundException {

		String userById = iUserService.deleteUserById(id);

		return ResponseEntity.ok(userById);
	}

	@GetMapping("/get-all-users")
	public ResponseEntity<?> getAll() {
		
		return new ResponseEntity<>(iUserService.getAllUserDetails(), HttpStatus.OK);
	}
}
