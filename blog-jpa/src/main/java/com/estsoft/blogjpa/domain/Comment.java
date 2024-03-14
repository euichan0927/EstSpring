package com.estsoft.blogjpa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable = false)
	private Long id;

	@Column(name="body",nullable = false)
	private String body;
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@OneToOne
	@JoinColumn(name="article_id",referencedColumnName = "id")
	private Article article;


}
