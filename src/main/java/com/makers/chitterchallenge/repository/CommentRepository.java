package com.makers.chitterchallenge.repository;

import com.makers.chitterchallenge.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findById(Long parent_chitter_id);

}
