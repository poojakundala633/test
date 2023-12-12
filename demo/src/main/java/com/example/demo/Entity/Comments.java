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

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class Comments {
    @Id
    private int comment_id;
    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Posts post;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate postedTime;
    private LocalDate updatedTime;
}
