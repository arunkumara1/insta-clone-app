package com.example.insta.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insta.entity.InstaUser;
import com.example.insta.entity.Post;
import com.example.insta.service.InstaService;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class InstaRestController {

	@Autowired
	private InstaService instaService;
	
	@GetMapping("/user")
	public List<InstaUser> getUsers() {

		List<InstaUser> instaUsers = instaService.findAllUser();

		return instaUsers;
	}
	
	@GetMapping("/userid/{username}")
	public InstaUser getUserId(@PathVariable String username) {

		InstaUser instaUser = instaService.findId(username);

		return instaUser;
	}
	
	@GetMapping("/user/{userId}")
	public InstaUser getEmployee(@PathVariable int userId) {

		InstaUser user = instaService.findById(userId);

		if(user == null) {
			throw new RuntimeException("User not found" + userId);

		}
		return instaService.findById(userId);

	}
	
	@PostMapping("/user")
	public InstaUser addUser(@RequestBody InstaUser user) {


		user.setId(0);

		instaService.saveUser(user);

		return user;

	}
	
	
	@PutMapping("/user")
	public InstaUser updateUser(@RequestBody InstaUser user) {

		instaService.saveUser(user);

		InstaUser userN = instaService.findById(user.getId());
		
		return userN;

	}
	
	@GetMapping("/post")
	public List<Post> getEmployees() {

		List<Post> posts = instaService.findAll();

		return posts;
	}
	
	
	@PostMapping("/post")
	public Post addEmployee(@RequestBody Post post) {

		post.setId(0);

		System.out.println("POSTs" + post);
		System.out.println("IMAGES " + post.getImages());	
		
		instaService.save(post);

		return post;

	}
	
}
