package com.isthisalis.website.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;

/**
 * Comment
 */
  @AllArgsConstructor @NoArgsConstructor @Builder @Entity @Table(name = "comments")
public class Comment {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Integer id;
  private @Getter @Setter @Column(name = "author", nullable = false) 
    String author;
  private @Getter @Setter @Column(name = "body", nullable = false)
    String body;
  private @Getter @Setter @Column(name = "createdat", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE") 
    Instant createdAt;
  private @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "post_id", nullable = false)
    Post post;
}
