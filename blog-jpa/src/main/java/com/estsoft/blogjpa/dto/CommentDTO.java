package com.estsoft.blogjpa.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
	private Long id;
	private String body;
	private LocalDateTime createdAt;
}
