package com.spring.rest.webservices.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.rest.webservices.exception.UserNotFoundException;
import com.spring.rest.webservices.filters.FilterClass;
import com.spring.rest.webservices.model.User;
import com.spring.rest.webservices.service.UserDaoService;

@RestController
public class UserController {

	@Autowired
	public UserDaoService userDaoService;

	@Autowired
	private FilterClass filterClass;

	@GetMapping(path = "/getAllUsers")
	public MappingJacksonValue getAllUsers() {
		return filterClass.getUsersFilter(userDaoService.getAllUsers());
	}

	@PostMapping(path = "/saveUser")
	public void saveUser(@Valid @RequestBody User user) {

		userDaoService.saveUser(user);

	}

	@GetMapping(path = "/getUserHateoas/{id}")
	public Resource<User> getUser(@PathVariable int id) {

		User user = userDaoService.getUser(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		Resource<User> resource = new Resource<User>(user);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());

		resource.add(linkTo.withRel("all-users"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "dob");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(user);

		mapping.setFilters(filters);

		return resource;
	}

	@GetMapping(path = "/getUser/{id}")
	public MappingJacksonValue getUserFiltered(@PathVariable int id) {

		User user = userDaoService.getUser(id);

		if (user == null)
			throw new UserNotFoundException("id-" + id);

		return filterClass.getUserFilter(user);
	}

}
