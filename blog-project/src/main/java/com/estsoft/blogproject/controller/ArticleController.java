package com.estsoft.blogproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogproject.Service.ArticleService;
import com.estsoft.blogproject.domain.Article;

@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/Articles")
	public List<Article> getArticles(){
		return articleService.getAllArticles();
	}

	@GetMapping("/Article/{id}")
	public Article getArticle(@PathVariable Long id){
		return articleService.getArticle(id);
	}

	@PostMapping("/Article")
	public int addArticle(@RequestParam String title, @RequestParam String content){
		return articleService.addArticle(title,content);
	}

	@PutMapping("Article/{id}")
	public int updateArticle(@RequestParam Long id,@RequestParam String title,@RequestParam String content){
		return articleService.updateArticle(id,title,content);
	}
	@DeleteMapping("Article/{id}")
	public int deleteArticle(@PathVariable Long id){
		return articleService.deleteArticle(id);
	}
}
