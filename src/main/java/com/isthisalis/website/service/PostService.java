package com.isthisalis.website.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.isthisalis.website.dto.CommentDTO;
import com.isthisalis.website.dto.PostDTO;
import com.isthisalis.website.entity.Comment;
import com.isthisalis.website.entity.Post;
import com.isthisalis.website.repository.CommentRepository;
import com.isthisalis.website.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<PostDTO> getAllPosts() {
        return postRepository.findAllOrderByCreatedAtDesc()
            .stream()
            .map(PostDTO::wrap)
            .toList();
    }

    public List<CommentDTO> getComments(long postId) {
        return commentRepository.findByPostIdOrderByCreatedAtDesc(postId)
            .stream()
            .map(CommentDTO::wrap)
            .toList();
    }

    public void addComment(long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        Comment comment = Comment.wrap(commentDTO);
            comment.setPost(post);

        commentRepository.save(comment);
    }

    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void editComment(long postId, long commentId) {
        
    }

    public void deletePost(long postId) {
        postRepository.deleteById(postId);
    }

    public void editPost(long postId, PostDTO postDTO) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setImage(postDTO.getImage());
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }
}
