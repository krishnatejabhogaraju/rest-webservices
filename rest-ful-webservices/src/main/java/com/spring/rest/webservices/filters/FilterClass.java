package com.spring.rest.webservices.filters;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.rest.webservices.model.Post;
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

	public MappingJacksonValue getPostsFilter(List<Post> postList) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "description");

		FilterProvider filters = new SimpleFilterProvider().addFilter("PostFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(postList);

		mapping.setFilters(filters);

		return mapping;

	}

	public MappingJacksonValue getPostFilter(Post post) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "description");

		FilterProvider filters = new SimpleFilterProvider().addFilter("PostFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(post);

		mapping.setFilters(filters);

		return mapping;

	}

}
