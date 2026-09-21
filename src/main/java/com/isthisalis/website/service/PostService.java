package com.isthisalis.website.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public List<PostDTO> getAllPosts() {
        return repository.findAll()
            .stream()
            .map(PostDTO::wrap)
            .toList();
    }
}
