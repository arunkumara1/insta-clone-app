package com.example.insta.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.insta.entity.InstaUser;
import com.example.insta.entity.Post;

@Repository
public class InstaDAOImpl implements InstaDAO {

	//define a field for Entity manager --> hibernate API

	private EntityManager entityManager;

	//Entitiy manager automatically creats by soring boot
	@Autowired
	public InstaDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<InstaUser> findAllUser() {
		//get hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		//craete the quiery

		Query<InstaUser> query = currentSession.createQuery("from InstaUser", InstaUser.class);
		// get the results

		List<InstaUser> users = query.getResultList();

		return users;
	}

	@Override
	public InstaUser findId(String username) {
		//get hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		//craete the quiery

		Query<InstaUser> query = currentSession.createQuery("from InstaUser where email=:uName ", InstaUser.class);
		query.setParameter("uName", username);
		// get the results

		InstaUser user = query.getResultList().get(0);

		return user;
	}

	@Override
	public InstaUser findById(int userId) {
		Session curentSession = entityManager.unwrap(Session.class);

		InstaUser user  = curentSession.get(InstaUser.class, userId);

		return user;
	}

	@Override
	public void saveUser(InstaUser user) {
		Session curentSession = entityManager.unwrap(Session.class);
		System.out.println(user);
		curentSession.saveOrUpdate(user);

	}

	@Override
	public List<Post> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		//craete the quiery

		Query<Post> query = currentSession.createQuery("from Post", Post.class);
		// get the results

		List<Post> posts = query.getResultList();

		return posts;
	}

	@Override
	public void save(Post post) {

		Session curentSession = entityManager.unwrap(Session.class);

		curentSession.saveOrUpdate(post);

	}

}
