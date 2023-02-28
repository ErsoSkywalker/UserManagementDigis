package com.digis.techtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.digis.techtask.exceptions.BadFormatException;
import com.digis.techtask.exceptions.DuplicateEntryException;
import com.digis.techtask.model.User;
import com.digis.techtask.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		if (user.isSomethingNull())
			throw new BadFormatException("Please make sure all fields are filled in correctly.");
		return validateLoginValue(user);
	}

	public User updateUser(User user) {
		if (user.getId() == null)
			throw new BadFormatException("You need to include the ID on the body request.");
		return validateLoginValue(user);
	}

	private User validateLoginValue(User user) {
		try {
			return userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateEntryException("Your login is already been used, please use other one.");
		}
	}

}
