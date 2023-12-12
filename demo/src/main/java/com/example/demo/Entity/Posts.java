package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Posts {
    @Id
    private int postId;
    private String post;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private LocalDate updatedTime;
}
