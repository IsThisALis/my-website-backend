package com.isthisalis.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isthisalis.website.entity.About;

/**
 * AboutRepository
 */
  @Repository
public interface AboutRepository extends JpaRepository<About, Integer> {}
