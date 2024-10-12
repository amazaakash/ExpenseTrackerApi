package com.aakash.ExpenseTrackerApiNew.service;

import org.hibernate.sql.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.aakash.ExpenseTrackerApiNew.entity.User;
import com.aakash.ExpenseTrackerApiNew.entity.UserModel;
import com.aakash.ExpenseTrackerApiNew.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(UserModel userModel) {
		User newUser = new User();
		BeanUtils.copyProperties(userModel, newUser);
		return userRepository.save(newUser);
	}

	@Override
	public User readUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user id not found " + id));

	}

	@Override
	public User updateUser(UserModel user, Long id) {
		User existinguser = readUser(id);
		existinguser.setName(user.getName() != null ? user.getName() : existinguser.getName());
		existinguser.setEmail(user.getEmail() != null ? user.getEmail() : existinguser.getEmail());
		existinguser.setPassword(user.getPassword() != null ? user.getPassword() : existinguser.getPassword());
		existinguser.setAge(user.getAge() != null ? user.getAge() : existinguser.getAge());
		return userRepository.save(existinguser);

	}

	@Override
	public void delete(Long id) {
		User user =readUser(id);
		userRepository.delete(user);
	}
}
