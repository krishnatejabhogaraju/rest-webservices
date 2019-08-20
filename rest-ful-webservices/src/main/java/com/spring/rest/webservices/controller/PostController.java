package com.spring.rest.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.rest.webservices.filters.FilterClass;

import com.spring.rest.webservices.service.PostDaoService;

@Controller
public class PostController {

	@Autowired
	private PostDaoService postDaoService;

	@Autowired
	private FilterClass filterClass;

	@GetMapping(path = "/getAllPosts/user/{id}/posts")
	public MappingJacksonValue getAllPosts(@PathVariable int id) {

		return filterClass.getPostsFilter(postDaoService.getAllPosts(id));
	}

	@GetMapping(path = "/getPost/{id}")
	public MappingJacksonValue getPost(@PathVariable int id) {

		return filterClass.getPostFilter(postDaoService.getPost(id));
	}

}
