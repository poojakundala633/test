package com.example.demo.Dto;
import com.example.demo.Entity.Posts;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LIkedDto {
    private int liked_id;
    private User user;
    private Posts post;
    private LocalTime likedTime;
    private LocalDate updatedTime;
}
