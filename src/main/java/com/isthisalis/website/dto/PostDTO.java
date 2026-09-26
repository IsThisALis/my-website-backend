package com.isthisalis.website.dto;

import java.time.Instant;

import com.isthisalis.website.entity.Post;

import lombok.Value;

/**
 * Post
 */
@Value
public class PostDTO {
  long id;
  String title;
  String content;
  String image;
  Instant date;

  public static PostDTO wrap(Post post) {
        return new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getImage(), post.getCreatedAt());
    }
}
