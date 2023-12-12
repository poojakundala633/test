package com.example.demo.Service;
import com.example.demo.Entity.Comments;
import com.example.demo.Dto.CommentsDto;
import com.example.demo.Repository.CommentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private CommentsRepository commentsRepository;

    private ModelMapper modelMapper;
    public CommentsServiceImpl() {modelMapper = new ModelMapper();}
    @Override
    public List<CommentsDto> getAllComments() {
        List<Comments> comments = commentsRepository.findAll();
        return comments.stream().map(post -> modelMapper.map(comments,CommentsDto.class)).collect(Collectors.toList());
    }

    @Override
    public CommentsDto getByCommentId(int commentId) {
        Optional<Comments> commentsOptional = commentsRepository.findById(commentId);
        return commentsOptional.map(comments -> modelMapper.map(comments,CommentsDto.class)).orElse(null);
    }

    @Override
    public CommentsDto saveComment(CommentsDto commentsDto) {
        Comments comments = modelMapper.map(commentsDto,Comments.class);
        Comments saveComments = commentsRepository.save(comments);
        return modelMapper.map(saveComments,CommentsDto.class);
    }

    @Override
    public CommentsDto updateComment(int commentId, CommentsDto commentsDto) {
        Optional<Comments> commentsOptional = commentsRepository.findById(commentId);
        if(commentsOptional.isPresent()){
            Comments existingCommit = commentsOptional.get();
            if(commentsDto.getPost()!=null){
                existingCommit.setPost(commentsDto.getPost());
            }
            Comments updateComment = commentsRepository.save(existingCommit);
            return modelMapper.map(updateComment,CommentsDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(int commentId) {
        commentsRepository.deleteById(commentId);
    }
}
