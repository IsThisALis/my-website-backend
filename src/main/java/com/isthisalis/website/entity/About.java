package com.isthisalis.website.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * About
 */
@NoArgsConstructor @AllArgsConstructor @Builder @Entity @Table(name = "about")
public class About {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Integer id;
  private @Getter @Setter @Column(name = "title", nullable = false)
    String title;
  private @Getter @Setter @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    String content;
  private @Getter @Setter @Column(name = "techstack", nullable = false)
    String techstack;
}
