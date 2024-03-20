package com.estsoft.blogjpa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.ArticleRepository;
import com.estsoft.blogjpa.repository.UserRepository;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	UserRepository userRepository;
	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	WebApplicationContext ac;

	@BeforeEach
	public void mockMvcSetUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ac).build();
	}
	@AfterEach
	public void cleanUp(){
		userRepository.deleteAll();
	}

	@Test
	void signup() throws Exception {
		//given : 회원가입에 필요한 정보 초기화
		AddUserRequest addUserRequest = new AddUserRequest("mock_email","mock_password");
		// userRepository.save(new User(addUserRequest.getEmail(),addUserRequest.getPassword()));
		//when : POST/user
		ResultActions resultActions = mockMvc.perform(post("/user").param("email",addUserRequest.getEmail()).param("password",addUserRequest.getPassword()));
		// resultActions.andExpect(status().isOk());
		//then : 호출 결과 HTTP Status Code 200 , user 저장 여부 검증
		resultActions.andExpect(status().is3xxRedirection()) ;
		User byEmail = userRepository.findByEmail(addUserRequest.getEmail()).orElseThrow();
		Assertions.assertNotNull(byEmail);
	}

	@Test
	public void deleteById() throws Exception {
		//given: 삭제할 대상 데이터 save
		Article article = articleRepository.save(new Article("title","content"));
		Long id =article.getId();

		//when : DELETE /thymeleaf/articles/{id}
		ResultActions resultActions = mockMvc.perform(delete("/thymeleaf/article/{id}",id));

		//then : 삭제 결과 확인 ,200 응답 코드 확인
		resultActions.andExpect(status().isOk());
		Optional<Article> optionalArticle = articleRepository.findById(id);
		assertFalse(optionalArticle.isPresent());

	}
}