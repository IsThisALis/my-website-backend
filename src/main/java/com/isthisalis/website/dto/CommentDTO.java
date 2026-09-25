package com.isthisalis.website.dto;

import java.time.Instant;

import com.isthisalis.website.entity.Comment;
import com.isthisalis.website.entity.Post;

import lombok.Value;

@Value
public class CommentDTO {
    String author;
    String body;
    Instant createdAt;
    Post post;

    public static CommentDTO wrap(Comment comment) {
        return new CommentDTO(comment.getAuthor(), comment.getBody(), comment.getCreatedAt(), comment.getPost());
    }
}