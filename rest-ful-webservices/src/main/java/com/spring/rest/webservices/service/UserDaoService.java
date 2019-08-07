package com.spring.rest.webservices.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.spring.rest.webservices.model.User;
import com.spring.rest.webservices.repository.UserRepository;

//23
@Component
public class UserDaoService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public User getUser(int id) {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}

	public void deleteUser(int id) {

		userRepository.deleteById(id);

	}

}
