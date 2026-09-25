package com.isthisalis.website.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    
    private final CommentRepository repository;

    public List<CommentDTO> getComments(long postId) {
        return repository.findByPostIdOrderByCreatedAtDesc(postId)
            .stream()
            .map(CommentDTO::wrap)
            .toList();
    }

}