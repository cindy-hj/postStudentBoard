package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.DTO.post.PostRequest;
import com.exam.DTO.post.PostResponse;
import com.exam.mapper.PostMapper;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	PostMapper m;
	
	@Transactional
	@Override
	public Long savePost(PostRequest params) {
		m.save(params);
		return params.getId();
	}

	@Override
	public PostResponse findPostById(Long id) {
		return m.findById(id);
	}

	@Override
	public Long updatePost(PostRequest params) {
		m.update(params);
		return params.getId();
	}

	@Transactional
	@Override
	public Long deletePost(Long id) {
		m.deleteById(id);
		return id;
	}

	@Override
	public List<PostResponse> findAllPost() {
		return m.findAll();
	}

	@Override
	public List<PostResponse> findByName(String name) {
		return m.findByName(name);
	}

}
