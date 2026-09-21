package com.isthisalis.website.dto;

import com.isthisalis.website.entity.About;

import lombok.Value;

/**
 * About
 */
@Value
public class AboutDTO {
  String title;
  String description;
  String techStack;

  public static AboutDTO wrap(About about) {
    return new AboutDTO(about.getTitle(), about.getContent(), about.getTechstack());
  }
}
