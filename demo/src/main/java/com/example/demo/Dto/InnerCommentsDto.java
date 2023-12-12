package com.example.demo.Dto;

import com.example.demo.Entity.Comments;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InnerCommentsDto {
    private int id;
    private String comments;
    private String userName;
    private User user;

    private Comments comment;
}
