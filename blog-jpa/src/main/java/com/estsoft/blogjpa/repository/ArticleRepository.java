package com.estsoft.blogjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.blogjpa.domain.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
