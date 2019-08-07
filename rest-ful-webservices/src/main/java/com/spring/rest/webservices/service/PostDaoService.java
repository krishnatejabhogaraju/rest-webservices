package com.spring.rest.webservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.webservices.model.Post;
import com.spring.rest.webservices.model.User;
import com.spring.rest.webservices.repository.PostRepository;
import com.spring.rest.webservices.repository.UserRepository;

@Component
public class PostDaoService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Post> getAllPosts(int id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get().getPost();
		} else {
			return null;
		}

	}

	public void savePost(Post post) {
		postRepository.save(post);
	}

	public Post getPost(int id) {
		Optional<Post> post = postRepository.findById(id);

		if (post.isPresent()) {
			return post.get();
		} else {
			return null;
		}

	}

}
