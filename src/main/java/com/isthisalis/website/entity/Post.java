package com.isthisalis.website.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.isthisalis.website.dto.PostDTO;

import jakarta.persistence.*;
import lombok.*;

/**
 * Post
 */  
@Entity
@Table(name = "posts") 
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor  
public class Post { 

  private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Long id;
  private @Setter @Column(name = "title", nullable = false)
    String title;
  private @Setter @Column(name = "content", nullable = false)
    String content;
  private @Setter @Column(name = "image")
    String image;
  private @Setter @Column(name = "createdat", nullable = false) 
    Instant createdAt;
  private @Builder.Default @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) @JoinColumn(name = "post_id") 
    List<Comment> comments = new ArrayList<>();

  public static Post wrap(PostDTO postDTO) {
    return new Post(null, postDTO.getTitle(), postDTO.getContent(), postDTO.getImage(), postDTO.getDate(), null);
  }
}