package com.spring.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.webservices.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
