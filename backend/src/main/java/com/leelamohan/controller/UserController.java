package com.leelamohan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.leelamohan.model.User;
import com.leelamohan.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public User newUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	}

	@GetMapping("/getAll")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/getByEmailAndPassword")
	User getUserByEmail(@RequestParam  String email, @RequestParam String password) {
		return userService.getByEmailAndPassword(email, password);
	}
}
