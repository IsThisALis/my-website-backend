package com.isthisalis.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.isthisalis.website.entity.Project;

/**
 * ProjectRepository
 */
  @Repository @CrossOrigin(origins = "https://isthisalis.github.io")
public interface ProjectRepository extends JpaRepository<Project, Integer> {}
