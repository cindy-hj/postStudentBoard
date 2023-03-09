package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.DTO.post.PostRequest;
import com.exam.DTO.post.PostResponse;

@Mapper
public interface PostMapper {
	/*
	 * 게시글 저장
	 */
	void save(PostRequest params);
	
	/*
	 * 게시글 상세정보 조회
	 */
	PostResponse findById(Long id);
	
	/*
	 * 게시글 수정
	 */
	void update(PostRequest params);
	
	/*
	 * 게시글 삭제
	 */
	void deleteById(Long id);
	
	/*
	 * 게시글 리스트 조회
	 */
	List<PostResponse> findAll();
	
	/*
	 * 이름으로 검색
	 */
	List<PostResponse> findByName(String name);

}
