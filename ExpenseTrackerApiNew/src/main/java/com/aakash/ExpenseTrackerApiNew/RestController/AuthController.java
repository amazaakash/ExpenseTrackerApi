package com.aakash.ExpenseTrackerApiNew.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.ExpenseTrackerApiNew.entity.User;
import com.aakash.ExpenseTrackerApiNew.entity.UserModel;
import com.aakash.ExpenseTrackerApiNew.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("User is logged in", HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel userModel) {
		return new ResponseEntity<User>(service.createUser(userModel), HttpStatus.CREATED);

	}
}
