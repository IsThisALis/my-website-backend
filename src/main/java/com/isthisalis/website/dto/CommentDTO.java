package com.isthisalis.website.dto;

import java.time.Instant;

import com.isthisalis.website.entity.Comment;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CommentDTO {

    @NotBlank(message = "Author cannot be empty!")
    @Max(value = 50, message = "Maximum of 50 symbols!")
    String author;

    @NotBlank
    @Size(max = 500)
    String body;

    Instant createdAt;

    public static CommentDTO wrap(Comment comment) {
        return new CommentDTO(comment.getAuthor(), comment.getBody(), comment.getCreatedAt());
    }
}