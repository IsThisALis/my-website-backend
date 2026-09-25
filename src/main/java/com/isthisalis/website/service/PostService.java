package com.isthisalis.website.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.entity.Post;
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

    public void delete(long postId) {
        repository.deleteById(postId);
    }

    public void editPost(long postId, PostDTO postDTO) {
        Post post = repository.findById(postId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setImage(postDTO.getImage());
    }

    public void addPost(Post post) {
        repository.save(post);
    }
}
