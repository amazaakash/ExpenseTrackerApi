package com.aakash.ExpenseTrackerApiNew.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.ExpenseTrackerApiNew.entity.User;
import com.aakash.ExpenseTrackerApiNew.entity.UserModel;
import com.aakash.ExpenseTrackerApiNew.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	

	@GetMapping("/users/{id}")
	public ResponseEntity<User> readUser(@PathVariable Long id) {
		return new ResponseEntity<User>(service.readUser(id), HttpStatus.OK);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody UserModel userModel, @PathVariable Long id) {
		return new ResponseEntity<User>(service.updateUser(userModel, id), HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUsers(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

	}
}
