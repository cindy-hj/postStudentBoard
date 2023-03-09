package com.exam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.DTO.post.PostRequest;
import com.exam.mapper.PostMapper;
import com.exam.DTO.post.PostResponse;

@SpringBootTest
public class PostMapperTest {
	
	@Autowired
	PostMapper mapper;
	
	@Test
	void save() {
		PostRequest params = new PostRequest();
		params.setTitle("1번 제목글");
		params.setContent("1번 내용글");
		params.setWriter("테스터");
		params.setNoticeYn(false);
		mapper.save(params);
		
		System.out.println("저장 완료");
	}
	
	@Test
	void update() {
		PostRequest params = new PostRequest();
		params.setId(1L);
		params.setTitle("1번 제목 수정");
		params.setContent("1번 내용 수정");
		params.setWriter("사용자");
		params.setNoticeYn(true);
		mapper.update(params);
		System.out.println("수정 완료");
	}

	@Test
	void delete() {
		mapper.deleteById(1L);
		System.out.println("삭제 완료");
	}
	
	@Test
	void findById() {
		PostResponse post = mapper.findById(1L);
		System.out.println("findById 수행완료");
	}

	
	
}
