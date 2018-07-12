package com.target.comments.repository;


import com.target.comments.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Comment, Long> {
}
