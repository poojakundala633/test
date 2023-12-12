package com.example.demo.Service;

import com.example.demo.Dto.InnerCommentsDto;

import java.util.List;

public interface InnerCommentsService {
    List<InnerCommentsDto> getAllInnerComments();
    InnerCommentsDto getByCommentsId(int innerCommentId);
    InnerCommentsDto saveComments(InnerCommentsDto innerCommentsDto);
    InnerCommentsDto updateComments(int innerCommentId, InnerCommentsDto innerCommentsDto);
    void deleteById(int innerCommentId);
}
