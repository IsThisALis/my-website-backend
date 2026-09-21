package com.isthisalis.website.service;

import java.util.List;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentService {
    
    private final CommentRepository repository;

    public List<CommentDTO> getComments(int postId) {
        return repository.findByPostIdOrderByCreatedAtDesc(postId)
            .stream()
            .map(CommentDTO::wrap)
            .toList();
    }

}