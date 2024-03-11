package com.estsoft.blogproject.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.estsoft.blogproject.domain.Article;
@Mapper
public interface ArticleMapper {
	List<Article> selectAllArticles();
	Article selectArticle(Long id);

	int addArticle(String title,String content);
	int updateArticle(Long id,String title,String content);
	int deleteArticle(Long id);
}
