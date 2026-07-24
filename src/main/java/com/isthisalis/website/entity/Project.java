package com.isthisalis.website.entity;

import lombok.*;
import jakarta.persistence.*;

/**
 * Project
 */
  @AllArgsConstructor @NoArgsConstructor @Builder @Entity @Table(name = "projects")
public class Project {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Integer id;
  private @Getter @Setter @Column(name = "techstack", nullable = false) 
    String techstack;
  private @Getter @Setter @Column(name = "name", nullable = false) 
    String name;
  private @Getter @Setter @Column(name = "description", nullable = false)
    String description;
  private @Getter @Setter @Column(name = "url", nullable = false)
    String url;
}
