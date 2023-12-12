package com.example.demo.Dto;

import com.example.demo.Entity.Posts;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CommentsDto {
    private int comment_id;
    private Posts post;
    private User user;
    private LocalDate postedTime;
    private LocalDate updatedTime;
}
