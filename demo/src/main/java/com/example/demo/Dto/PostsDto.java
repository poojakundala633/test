package com.example.demo.Dto;
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
public class PostsDto {
    private int postId;
    private String post;
    private String email;
    private String password;

    private User user;
    private LocalDate updatedTime;
}
