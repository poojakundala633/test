package com.example.demo.Service;

import com.example.demo.Dto.PostsDto;
import com.example.demo.Entity.Posts;
import com.example.demo.Repository.PostsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostsRepository postsRepository;

    private ModelMapper modelMapper;
    public PostServiceImpl() {modelMapper = new ModelMapper();}
    @Override
    public List<PostsDto> getAllPosts() {
        List<Posts> posts = postsRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostsDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostsDto getByPostId(int postId) {
        Optional<Posts> postsOptional = postsRepository.findById(postId);
        return postsOptional.map(posts -> modelMapper.map(posts, PostsDto.class)).orElse(null);
    }

    @Override
    public PostsDto savePost(PostsDto postDto) {
        Posts post = modelMapper.map(postDto, Posts.class);
        Posts savePosts  =  postsRepository.save(post);
        return modelMapper.map(savePosts,PostsDto.class);
    }

    @Override
    public PostsDto updatePost(int postId, PostsDto postDto) {
        Optional<Posts> postsOptional = postsRepository.findById(postId);
        if(postsOptional.isPresent()){
            Posts existingPost = postsOptional.get();
            if(postDto.getPost()!=null){
                existingPost.setPost(postDto.getPost());
            }
            Posts updatePost = postsRepository.save(existingPost);
            return modelMapper.map(updatePost,PostsDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(int postId) {
    postsRepository.deleteById(postId);
    }
}
