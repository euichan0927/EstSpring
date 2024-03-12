package com.estsoft.blogjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.repository.ArticleRepository;

import jakarta.transaction.Transactional;

@Service
public class ArticleService {
	private final ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	public Article save(AddArticleRequest request){
		return articleRepository.save(request.toEntity());
	}
	public List<Article> getAllArticles(){
		return articleRepository.findAll();
	}

	public Article getArticle(Long id){
		return articleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found id"));
	}

	public void deleteArticle(Long id){
		articleRepository.deleteById(id);
	}
	@Transactional	//데이터관련 처리가 있을 때 데이터를 바꾸기 위한 작업 단위
	public void updateArticle(Long id,AddArticleRequest request){
		Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id"));
		article.update(request.getTitle(), request.getContent());
	}
}
