package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.PostServiceImpl;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostServiceImpl postService;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/findAll")
	public ArrayList<PostDto> findAllPost() {
		try {
			return toDto.listPostToDto(postService.findAllPost());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addPost")
	public boolean addPost(@RequestBody PostDto post) {
		try {
			return postService.addPost(dtoTo.postToDao(post));
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	@DeleteMapping("/deletePost")
	public boolean deletePost(@Param(value = "id") long id) {
		try {
			return postService.deletePost(id);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@PostMapping("/updatePost")
	public boolean updatePost(@RequestBody PostDto dto) {
		try {
			return postService.updatePost(dtoTo.postToDao(dto));
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

}
