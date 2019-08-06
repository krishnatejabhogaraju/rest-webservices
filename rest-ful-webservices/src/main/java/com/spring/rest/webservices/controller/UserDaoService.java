package com.spring.rest.webservices.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.rest.webservices.model.User;

//23
@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private int userCount = 1;

	static {

		users.add(new User(1, "Krishna", new Date(),"234556","Hyderabad"));

	}

	public List<User> getAllUsers() {

		return users;
	}

	public void saveUser(User user) {

		userCount = userCount + 1;

		user.setId(userCount);

		users.add(user);

	}

	public User getUser(int id) {

		User user1 = null;

		for (User user : users) {

			if (user.getId() == id) {

				user1 = user;

				return user1;

			}
		}

		return user1;

	}

	public void deleteUser() {

	}

}
