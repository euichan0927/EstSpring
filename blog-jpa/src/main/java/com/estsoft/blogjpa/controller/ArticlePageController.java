package com.estsoft.blogjpa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.dto.ArticleViewResponse;
import com.estsoft.blogjpa.service.ArticleService;

import jakarta.transaction.Transactional;

@RestController
public class ArticlePageController {
	private ArticleService articleService;

	public ArticlePageController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("thymeleaf/articles")
	public String getArticles(Model model){
		List<ArticleViewResponse> articles = articleService.getAllArticles().stream().map(ArticleViewResponse::new).toList();
		model.addAttribute("articles",articles);
		return "articleList";
	}

	@GetMapping("thymeleaf/article/{id}")
	public String showArticle(@PathVariable Long id,Model model){
		Article article = articleService.getArticle(id);
		model.addAttribute("article",new ArticleViewResponse(article));

		return "article";
	}

	@DeleteMapping("thymeleaf/article/{id}")
	public void deleteArticle(@PathVariable Long id){
		articleService.deleteArticle(id);
	}

	@GetMapping("/new-article")
	public String newArticle(@RequestParam(required = false) Long id,Model model){
		if(id==null){
			model.addAttribute("article",new ArticleViewResponse());
		}else{
			Article article = articleService.getArticle(id);
			model.addAttribute("article",new ArticleViewResponse(article));
		}
		return "newArticle";
	}

	@Transactional
	@PutMapping("thymeleaf/article/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody AddArticleRequest addArticleRequest) {
		Article article = articleService.getArticle(id);
		article.update(addArticleRequest.getTitle(), addArticleRequest.getContent());
		return ResponseEntity.ok(article); // 업데이트된 Article 객체 반환
	}

	@PostMapping("thymeleaf/article")
	public String addArticle(@RequestBody AddArticleRequest addArticleRequest){
		articleService.save(addArticleRequest);
		return "articleList";
	}

}
