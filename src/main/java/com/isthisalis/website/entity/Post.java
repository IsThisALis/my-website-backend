package com.isthisalis.website.entity;

import java.time.Instant;

import jakarta.persistence.*;

import lombok.*;

/**
 * Post
 */  
  @Builder @NoArgsConstructor @AllArgsConstructor @Entity @Table(name = "posts") 
public class Post { 

  private @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Integer id;
  private @Getter @Setter @Column(name = "title", nullable = false)
    String title;
  private @Getter @Setter @Column(name = "content", nullable = false)
    String content;
  private @Getter @Setter @Column(name = "image", nullable = true)
    String image;
  private @Getter @Setter @Column(name = "createdat", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE") 
    Instant createdAt;
}
