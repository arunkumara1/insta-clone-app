package com.example.insta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insta.dao.InstaDAO;
import com.example.insta.entity.InstaUser;
import com.example.insta.entity.Post;

@Service
public class InstaServiceImpl implements InstaService {

	@Autowired
	private InstaDAO instaDAO;
	
	
	@Override
	@Transactional
	public List<InstaUser> findAllUser() {	
		return instaDAO.findAllUser();
	}

	@Override
	@Transactional
	public InstaUser findId(String username) {
		return instaDAO.findId(username);
	}

	@Override
	@Transactional
	public InstaUser findById(int userId) {
		return instaDAO.findById(userId);
	}

	@Override
	@Transactional
	public void saveUser(InstaUser user) {
		instaDAO.saveUser(user);
	}

	@Override
	@Transactional
	public List<Post> findAll() {
		return instaDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Post post) {
		instaDAO.save(post);
	}

}
