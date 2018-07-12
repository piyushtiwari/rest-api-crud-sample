package com.target.comments.controller;


import java.util.List;

import com.sun.tools.javap.TypeAnnotationWriter;
import com.target.comments.exception.ResourceNotFoundException;
import com.target.comments.model.Comment;
import com.target.comments.repository.CommentRepository;
import com.target.comments.repository.ProductRepository;
import com.target.comments.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product/{productId}/comment")
    public Comment createComment(@Valid @RequestBody Comment comment) {

        return commentRepository.save(comment);
    }

    // Get a Single Comment
    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable(value = "id") Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", commentId));
    }

    @PutMapping("/comment/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long commentId,
                           @Valid @RequestBody Comment commentDetails) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", commentId));

        comment.setContent(commentDetails.getContent());
        comment.setIsPublished(commentDetails.getIsPublished());

        Comment updatedComment = commentRepository.save(comment);
        return updatedComment;
    }


    // Get all Comments
    @GetMapping("/comment")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}