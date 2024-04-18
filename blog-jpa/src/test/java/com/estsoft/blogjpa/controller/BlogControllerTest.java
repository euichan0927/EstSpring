package com.estsoft.blogjpa.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.service.ArticleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {
	@Mock
	ArticleService articleService;

	@InjectMocks
	ArticleController articleController;

	MockMvc mockMvc;

	@BeforeEach
	void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
	}
	@DisplayName("블로그 정보 추가 - POST /api/articles")
	@Test
	void testAddArticle() throws Exception {
		//given:
		AddArticleRequest request = new AddArticleRequest("제목","내용");
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(request);

		Mockito.doReturn(new Article(request.getTitle(),request.getContent()))
			.when(articleService).save(any(AddArticleRequest.class));
		//when:
		ResultActions resultActions = mockMvc.perform(post("/Article")
			.content(requestJson).contentType(MediaType.APPLICATION_JSON));

		//then:
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("title").value(request.getTitle()))
			.andExpect(jsonPath("content").value(request.getContent()));

		Mockito.verify(articleService,times(1)).save(any());
	}

	@DisplayName("블로그 글 전체 목록 조회")
	@Test
	public void testArticleList() throws Exception{

		//given :
		Long id = 123L;
		doReturn(new Article("title","content"))
				.when(articleService).findById(anyLong());

		//when :
		ResultActions resultActions = mockMvc.perform(get("Articles"));

		//then :
		resultActions.andExpect(status().isOk())
			.andExpect(jsonPath("title").value("title"))
			.andExpect(jsonPath("content").value("content"));
	}
}
