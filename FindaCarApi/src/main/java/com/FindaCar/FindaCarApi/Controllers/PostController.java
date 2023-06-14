package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.PostServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080","http://localhost:80" })
public class PostController {

	@Autowired
	PostServiceImpl postService;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;

	@GetMapping("/findAll")
	public ArrayList<PostDto> findAllPost() {
		Logger.log("Entering endpoint /post/findAll");
		try {
			Logger.log("Returning all posts");
			return toDto.listPostToDto(postService.findAllPost());
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /post/findAll");
			return null;
		}
	}

	@PutMapping("/addPost")
	public boolean addPost(@RequestBody PostDto post) {
		Logger.log("Entering endpoint /post/addPost");
		try {
			Logger.log("Creating new post");
			Logger.log(post.toString());
			return postService.addPost(dtoTo.postToDao(post));
		} catch (Exception e) {
			Logger.log("Error in /post/addPost");
			System.out.println(e.getMessage());
			return false;
			// TODO: handle exception
		}
	}

	@DeleteMapping("/deletePost")
	public boolean deletePost(@Param(value = "id") long id) {
		Logger.log("Entering endpoint /post/deletePost");
		try {
			Logger.log("Deleting post");
			return postService.deletePost(id);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /post/deletePost");
			return false;
		}
	}

	@PostMapping("/updatePost")
	public boolean updatePost(@RequestBody PostDto dto) {
		Logger.log("Entering endpoint /post/updatePost");
		try {
			Logger.log("Updating post");
			return postService.updatePost(dtoTo.postToDao(dto));
		} catch (Exception e) {
			Logger.log("Error in /post/updatePost");
			return false;
			// TODO: handle exception
		}
	}

	@GetMapping("/findById")
	public PostDto findById(@Param(value = "id") long id) {
		Logger.log("Entering endpoint /post/updatePost");
		try {
			Logger.log("Returning post with id:" + id);
			return toDto.postToDto(postService.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
