package com.isthisalis.website.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.entity.Post;

import com.isthisalis.website.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    
    private final PostService postService;

    @GetMapping("/{postId}/comments")
    public List<CommentDTO> getComments(@PathVariable int postId) {
        return postService.getComments(postId);
    }

    @PostMapping("/{postId}/comments/add")
    public void addComment(@PathVariable long postId, @RequestBody CommentDTO comment) {
        postService.addComment(postId, comment);
    }

    @PatchMapping("/{postId}/comments/{commentId}/edit")
    public void editComment(@PathVariable long postId, @PathVariable long commentId, @RequestBody CommentDTO commentDTO) {

    }

    @GetMapping
    public List<PostDTO> getPosts() {
        return postService.getAllPosts();
    }


    @DeleteMapping("/{postId}/delete")
    public void deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
    }


    @PatchMapping("/{postId}/edit")
    public void editPost(@PathVariable int postId, @Valid @RequestBody PostDTO postDTO) {
        postService.editPost(postId, postDTO);
    }

    @PostMapping
    public void addPost(@Valid @RequestBody PostDTO post) {
        postService.addPost(Post.wrap(post));
    }
}
