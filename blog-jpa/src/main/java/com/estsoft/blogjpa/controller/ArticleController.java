package com.estsoft.blogjpa.controller;

import java.util.List;
import java.util.Optional;

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
import com.estsoft.blogjpa.service.ArticleService;

@RestController
public class ArticleController {
	private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("Articles")
	public List<Article> getAllArticles(){
		return articleService.getAllArticles();
	}
	@PostMapping("Article")
	public void addArticle(@RequestBody AddArticleRequest addArticleRequest){
		articleService.save(addArticleRequest);
	}

	@GetMapping("Article/{id}")
	public Article getArticle(@PathVariable Long id){
		return articleService.getArticle(id);
	}
	@DeleteMapping("Article/{id}")
	public void deleteArticle(@PathVariable Long id){
		articleService.deleteArticle(id);
	}
	@PutMapping("Article/{id}")
	public void updateArticle(@PathVariable Long id,@RequestBody AddArticleRequest addArticleRequest){
		articleService.updateArticle(id, addArticleRequest);
	}
}

