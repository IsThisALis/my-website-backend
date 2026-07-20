package com.isthisalis.website.DTO;

import java.time.Instant;

import lombok.Data;

/**
 * Post
 */
  @Data
public class Post {
  private String title;
  private String text;
  private String image;
  private Instant date;
}
