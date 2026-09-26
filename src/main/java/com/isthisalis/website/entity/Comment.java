package com.isthisalis.website.entity;

import java.time.Instant;

import com.isthisalis.website.dto.CommentDTO;

import jakarta.persistence.*;
import lombok.*;

/**
 * Comment
 */
@AllArgsConstructor @NoArgsConstructor @Builder @Entity @Table(name = "comments")
public class Comment {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Long id;
  private @Getter @Setter @Column(name = "author", nullable = false) 
    String author;
  private @Getter @Setter @Column(name = "body", nullable = false)
    String body;
  private @Getter @Column(name = "createdat", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE") 
    Instant createdAt;
  private @Getter @Setter @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "post_id", nullable = false)
    Post post;

    public static Comment wrap(CommentDTO commentDTO) {
      return new Comment(null, commentDTO.getAuthor(), commentDTO.getBody(), commentDTO.getCreatedAt(), commentDTO.getPost());
    }
}
