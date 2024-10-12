package com.aakash.ExpenseTrackerApiNew.service;

import com.aakash.ExpenseTrackerApiNew.entity.User;
import com.aakash.ExpenseTrackerApiNew.entity.UserModel;

public interface UserService {

	User createUser(UserModel userModel);
	
	User readUser(Long id);
	
	User updateUser(UserModel user,Long id);
	
	void delete(Long id);
}
