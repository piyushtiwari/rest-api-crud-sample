package com.target.comments.repository;


import com.target.comments.model.Comment;
import com.target.comments.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
