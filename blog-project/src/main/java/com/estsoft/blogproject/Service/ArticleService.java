package com.estsoft.blogproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.blogproject.domain.Article;
import com.estsoft.blogproject.repository.ArticleMapper;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	public ArticleService(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}

	public List<Article> getAllArticles(){
		return articleMapper.selectAllArticles();
	}
	public Article getArticle(Long id){
		return articleMapper.selectArticle(id);
	}
	public int addArticle(String title, String content){
		return articleMapper.addArticle(title,content);
	}
	public int updateArticle(Long id,String title,String content){
		return articleMapper.updateArticle(id,title,content);
	}
	public int deleteArticle(Long id){
		return articleMapper.deleteArticle(id);
	}

}
