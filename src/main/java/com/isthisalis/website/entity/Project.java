package com.isthisalis.website.entity;

import com.isthisalis.website.dto.ProjectDTO;

import jakarta.persistence.*;
import lombok.*;

/**
 * Project
 */
@AllArgsConstructor @NoArgsConstructor @Builder @Entity @Table(name = "projects")
public class Project {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Long id;
  private @Getter @Setter @Column(name = "techstack", nullable = false) 
    String techstack;
  private @Getter @Setter @Column(name = "name", nullable = false) 
    String name;
  private @Getter @Setter @Column(name = "description", nullable = false)
    String description;
  private @Getter @Setter @Column(name = "url", nullable = false)
    String url;

  public static Project wrap(ProjectDTO projectDTO) {
    return new Project(null, projectDTO.getTechStack(), projectDTO.getName(), projectDTO.getDescription(), projectDTO.getUrl());
  }
}
