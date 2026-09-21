package com.isthisalis.website.dto;

import com.isthisalis.website.entity.Project;

import lombok.Value;

/**
 * Project
 */
@Value
public class ProjectDTO {
  String techStack;
  String name;
  String description;
  String url;

  public static ProjectDTO wrap(Project project) {
    return new ProjectDTO(project.getTechstack(), project.getName(), project.getDescription(), project.getUrl());
  }
}
