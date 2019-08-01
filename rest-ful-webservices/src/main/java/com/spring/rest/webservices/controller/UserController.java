package com.spring.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.webservices.exception.UserNotFoundException;
import com.spring.rest.webservices.model.User;

@RestController
public class UserController {

	@Autowired
	public UserDaoService userDaoService;

	@GetMapping(path = "/getAllUsers")
	public List<User> getAllUsers() {
		return userDaoService.getAllUsers();
	}

	@PostMapping(path = "/saveUser")
	public void savUser(@RequestBody User user) {

		userDaoService.saveUser(user);

	}

	@GetMapping(path = "/getUser/{id}")
	public User getUser(@PathVariable int id) {

		User user = userDaoService.getUser(id);
		
		if(user==null) throw new UserNotFoundException("id-"+id);
		return user;
	}

}
