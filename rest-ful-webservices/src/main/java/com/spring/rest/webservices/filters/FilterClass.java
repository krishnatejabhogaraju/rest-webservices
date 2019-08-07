package com.spring.rest.webservices.filters;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.rest.webservices.model.User;

@Component
public class FilterClass {

	public MappingJacksonValue getUsersFilter(List<User> userList) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "dob", "password",
				"city");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(userList);

		mapping.setFilters(filters);

		return mapping;

	}

	public MappingJacksonValue getUserFilter(User user) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "dob", "password",
				"city");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(user);

		mapping.setFilters(filters);

		return mapping;

	}

}
