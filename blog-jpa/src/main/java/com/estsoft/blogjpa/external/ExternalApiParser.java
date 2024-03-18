package com.estsoft.blogjpa.external;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.service.ArticleService;
@Component
public class ExternalApiParser {
	//외부 API 호출 -> json 받아오기
	private final String API_URL = "https://jsonplaceholder.typicode.com/posts";

	private ArticleService articleService;

	public ExternalApiParser(ArticleService articleService) {
		this.articleService = articleService;
	}

	public void parser() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = restTemplate.getForEntity(API_URL, List.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			List<LinkedHashMap<String,Object>> list = response.getBody();
			List<AddArticleRequest> insertList = new ArrayList<>();
			for(LinkedHashMap<String,Object> map : list){
				String title = (String)map.get("title");
				String content = (String)map.get("body");

				articleService.save(new AddArticleRequest(title,content));
			}
		}

	}

}
