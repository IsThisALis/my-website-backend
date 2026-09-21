package com.isthisalis.website.dto;

import java.time.Instant;

import com.isthisalis.website.entity.Post;

import lombok.Value;

/**
 * Post
 */
@Value
public class PostDTO {
  String title;
  String text;
  String image;
  Instant date;

  public static PostDTO wrap(Post post) {
        return new PostDTO(post.getTitle(), post.getContent(), post.getImage(), post.getCreatedAt());
    }
}
