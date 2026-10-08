package com.isthisalis.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isthisalis.website.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    public Optional<Tag> findByName(String name);
    public void deleteByName(String name);
}
