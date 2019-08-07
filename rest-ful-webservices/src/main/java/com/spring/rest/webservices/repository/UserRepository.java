package com.spring.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.webservices.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
