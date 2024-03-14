package com.estsoft.blogjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.blogjpa.domain.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
