package com.estsoft.blogjpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.ArticleViewResponse;
import com.estsoft.blogjpa.service.ArticleService;

@Controller
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
}
