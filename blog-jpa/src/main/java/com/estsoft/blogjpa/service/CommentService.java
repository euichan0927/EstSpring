package com.estsoft.blogjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.Comment;
import com.estsoft.blogjpa.dto.CommentDTO;
import com.estsoft.blogjpa.repository.ArticleRepository;
import com.estsoft.blogjpa.repository.CommentRepository;
@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ArticleRepository articleRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	public void addComment(Long articleId,String body){
		Article article = articleRepository.findById(articleId).orElseThrow(RuntimeException::new);
		Comment comment = new Comment();
		comment.setComment(article,body);
		commentRepository.save(comment);
	}
	public CommentDTO showComment(Long articleId,Long commentId){
		return convertToDto(commentRepository.findById(commentId).orElse(null));
	}
	private CommentDTO convertToDto(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setBody(comment.getBody());
		dto.setCreatedAt(comment.getCreatedAt());
		return dto;
	}
}
