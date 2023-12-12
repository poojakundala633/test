package com.example.demo.Controller;


import com.example.demo.Dto.PostsDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostService postService;


    @GetMapping
    public ResponseEntity<List<PostsDto>> findAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostsDto> savePosts(@RequestBody PostsDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto),HttpStatus.CREATED);
    }
    @PatchMapping("/{postId}")
    public ResponseEntity<PostsDto> updatePostById(@PathVariable int postId, @RequestBody PostsDto postDto) {
        PostsDto updatedPost = postService.updatePost(postId,postDto);
        if (updatedPost != null) {
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteById(@PathVariable int postId) {
        postService.deleteById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostsDto> getPostById(@PathVariable int postId) {
        PostsDto postDto = postService.getByPostId(postId);
        if (postDto != null) {
            return new ResponseEntity<>(postDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
