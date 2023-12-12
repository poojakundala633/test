package com.example.demo.Service;

import com.example.demo.Dto.CommentsDto;

import java.util.List;

public interface CommentsService {
    List<CommentsDto> getAllComments();
    CommentsDto getByCommentId(int commentId);
    CommentsDto saveComment(CommentsDto commentsDto);
    CommentsDto updateComment(int commentId, CommentsDto commentsDto);
    void deleteById(int commentId);
}
