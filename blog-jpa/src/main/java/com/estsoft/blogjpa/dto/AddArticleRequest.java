package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
	private String title;
	private String content;

	public Article toEntity(){
		return Article.builder()
			.title(title)
			.content(content)
			.build();
	}
}
