package com.example.demo.Controller;
import com.example.demo.Dto.CommentsDto;
import com.example.demo.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;


    @GetMapping
    public ResponseEntity<List<CommentsDto>> findAllComments(){
        return new ResponseEntity<>(commentsService.getAllComments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentsDto> saveComments(@RequestBody CommentsDto commentsDto){
        return new ResponseEntity<>(commentsService.saveComment(commentsDto),HttpStatus.CREATED);
    }
    @PatchMapping("/{commentId}")
    public ResponseEntity<CommentsDto> updateCommentsById(@PathVariable int commentId, @RequestBody CommentsDto commentsDto) {
        CommentsDto updatedComments = commentsService.updateComment(commentId,commentsDto);
        if (updatedComments != null) {
            return new ResponseEntity<>(updatedComments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteById(@PathVariable int commentId) {
        commentsService.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentsDto> getCommentById(@PathVariable int commentId) {
        CommentsDto commentsDto = commentsService.getByCommentId(commentId);
        if (commentsDto != null) {
            return new ResponseEntity<>(commentsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


