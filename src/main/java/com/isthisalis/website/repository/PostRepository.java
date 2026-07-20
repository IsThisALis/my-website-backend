package com.isthisalis.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isthisalis.website.entity.Post;

/**
 * PostRepository
 */
  @Repository
public interface PostRepository extends JpaRepository<Post, Integer> {}
