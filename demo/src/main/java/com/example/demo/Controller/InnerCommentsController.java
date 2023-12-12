package com.example.demo.Controller;

import com.example.demo.Dto.InnerCommentsDto;
import com.example.demo.Service.InnerCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/innerComments")
public class InnerCommentsController {
    @Autowired
    private InnerCommentsService innerCommentsService;


    @GetMapping
    public ResponseEntity<List<InnerCommentsDto>> findAllComments(){
        return new ResponseEntity<>(innerCommentsService.getAllInnerComments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InnerCommentsDto> saveComments(@RequestBody InnerCommentsDto innerCommentsDto){
        return new ResponseEntity<>(innerCommentsService.saveComments(innerCommentsDto),HttpStatus.CREATED);
    }
    @PatchMapping("/{commentsId}")
    public ResponseEntity<InnerCommentsDto> updateCommentsById(@PathVariable int innerCommentsId, @RequestBody InnerCommentsDto innerCommentsDto) {
        InnerCommentsDto updatedinnerComments = innerCommentsService.updateComments(innerCommentsId,innerCommentsDto);
        if (updatedinnerComments != null) {
            return new ResponseEntity<>(updatedinnerComments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{innerCommentId}")
    public ResponseEntity<Void> deleteById(@PathVariable int innerCommentId) {
        innerCommentsService.deleteById(innerCommentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{innerCommentId}")
    public ResponseEntity<InnerCommentsDto> getCommentById(@PathVariable int innerCommentId) {
        InnerCommentsDto innerCommentsDto = innerCommentsService.getByCommentsId(innerCommentId);
        if (innerCommentsDto != null) {
            return new ResponseEntity<>(innerCommentsDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
