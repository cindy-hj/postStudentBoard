package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.DTO.post.PostRequest;
import com.exam.DTO.post.PostResponse;
import com.exam.service.PostService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PostController{

	@Autowired
	PostService s;
	
	@PostMapping("/savepost")
	public Long savePost(@RequestBody PostRequest params){
		s.savePost(params);
		return params.getId();
	}
	
	@GetMapping("/findbyid")
	public PostResponse findByIdPost(@RequestParam("id")Long id){
		return s.findPostById(id);
	}
	
	@PostMapping("/update")
	public Long updatePost(@RequestBody PostRequest params) {
		s.updatePost(params);
		return params.getId();
	}
	
	@GetMapping("/delete")
	public Long deletePost(@RequestParam("id")Long id) {
		s.deletePost(id);
		return id;
	}
	
	@GetMapping("/findall")
	public List<PostResponse> findAllPost(HttpServletRequest request){
		return s.findAllPost();
		
	}
	
	@GetMapping("/findname")
	public List<PostResponse> findByName(@RequestParam("name")String name) {
		return s.findByName(name);
	}
}
