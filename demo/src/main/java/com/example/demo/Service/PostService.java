package com.example.demo.Service;

import com.example.demo.Dto.PostsDto;

import java.util.List;

public interface PostService {
    List<PostsDto> getAllPosts();
    PostsDto getByPostId(int postId);
    PostsDto savePost(PostsDto postDto);
    PostsDto updatePost(int postId, PostsDto postDto);
    void deleteById(int postId);
}
