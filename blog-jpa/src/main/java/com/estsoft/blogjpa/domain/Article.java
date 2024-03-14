package com.estsoft.blogjpa.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable = false)
	private Long id;

	@Column(name="title",nullable = false)
	private String title;

	@Column(name="content",nullable = false)
	private String content;

	@CreatedDate
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	@JsonIgnore
	@OneToOne(mappedBy = "article",fetch = FetchType.LAZY)
	private Comment comment;

	@Builder
	public Article(String title, String content){
		this.title=title;
		this.content=content;
	}

	public void update(String title,String content){
		this.title=title;
		this.content=content;
	}
}
