package com.pyo.yourspick;

import com.pyo.yourspick.domain.post.Post;
import com.pyo.yourspick.domain.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest(classes = pickyoursApplication.class)
class YourspickApplicationTests {

	@Autowired
	PostRepository postRepository;

	@Autowired Page pageable;

	@Test
	void contextLoads() {
	}

	@Test
	public void 제목검색(){




	}

}
