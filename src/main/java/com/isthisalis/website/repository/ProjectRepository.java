package com.isthisalis.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isthisalis.website.entity.Project;

/**
 * ProjectRepository
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {}
