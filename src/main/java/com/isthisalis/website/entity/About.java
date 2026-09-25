package com.isthisalis.website.entity;

import com.isthisalis.website.dto.AboutDTO;

import jakarta.persistence.*;
import lombok.*;

/**
 * About
 */
@NoArgsConstructor @AllArgsConstructor @Builder @Entity @Table(name = "about")
public class About {

  private @Getter @Setter @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    Long id;
  private @Getter @Setter @Column(name = "title", nullable = false)
    String title;
  private @Getter @Setter @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    String content;
  private @Getter @Setter @Column(name = "techstack", nullable = false)
    String techstack;

    public static About wrap(AboutDTO aboutDTO) {
      return new About(null, aboutDTO.getTitle(), aboutDTO.getContent(), aboutDTO.getTechStack());
    }
}
