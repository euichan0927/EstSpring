package com.estsoft.blogjpa.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.Comment;
import com.estsoft.blogjpa.dto.CommentDTO;
import com.estsoft.blogjpa.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/comments/{articleId}")
	public void addComment(@PathVariable Long articleId,@RequestBody Map<String,String> body){
		commentService.addComment(articleId, body.get("body"));
	}

	@GetMapping("/comments/{articleId}/{commentId}")
	public CommentDTO showComment(@PathVariable Long articleId , @PathVariable Long commentId){
		return commentService.showComment(articleId,commentId);
	}

}
