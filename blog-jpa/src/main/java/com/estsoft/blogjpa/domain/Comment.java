package com.estsoft.blogjpa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable = false)
	private Long id;

	@Column(name="body",nullable = false,columnDefinition = "TEXT")
	private String body;

	@CreatedDate
	@Column(name="created_at")
	private LocalDateTime createdAt;

	@OneToOne
	@JoinColumn(name="article_id",referencedColumnName = "id")
	private Article article;

	public void setComment(Article article,String body){
		this.article=article;
		this.body=body;
	}


}
