package com.example.insta.service;

import java.util.List;

import com.example.insta.entity.InstaUser;
import com.example.insta.entity.Post;

public interface InstaService {

	public List<InstaUser> findAllUser();

	public InstaUser findId(String username);

	public InstaUser findById(int userId);

	public void saveUser(InstaUser user);

	public List<Post> findAll();

	public void save(Post post);

}
