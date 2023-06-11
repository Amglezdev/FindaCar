package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.repositories.PostRepository;

@Component
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public ArrayList<Post> findAllPost() {
		try {
			return (ArrayList<Post>) postRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean addPost(Post post) {
		try {			
			postRepo.save(post);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletePost(Long id) {
		try {
			postRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updatePost(Post post) {
		try {
			postRepo.save(post);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Post findById(Long id) {
		try {
			return postRepo.findById(id).orElse(null);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
