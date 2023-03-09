package com.exam.service;

import java.util.List;

import com.exam.DTO.post.PostRequest;
import com.exam.DTO.post.PostResponse;

public interface PostService {
	public Long savePost(PostRequest params);
	public PostResponse findPostById(Long id);
	public Long updatePost(PostRequest params);
	public Long deletePost(Long id);
	public List<PostResponse> findAllPost();
	public List<PostResponse> findByName(String name);
}
