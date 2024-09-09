package com.leelamohan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leelamohan.model.User;
import com.leelamohan.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		Optional<User> foundUser = userRepository.findById(id);
		if (foundUser == null || foundUser.get().getId() == null) {
			return null;
		}
		return foundUser.get();
	}

	public User getByEmailAndPassword(String email,String password) {
		User foundUser = userRepository.findByEmailAndPassword(email,password);
		if (foundUser == null || foundUser.getId() == null) {
			return null;
		}
		return foundUser;
	}
}
