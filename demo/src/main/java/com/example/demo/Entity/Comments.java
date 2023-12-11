package com.example.demo.Entity;

import jakarta.persistence.Entity;
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
    private int comment_id;
    @ManyToOne()
    @JoinColumn(name = "post_id")
    private int post_id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private int user_id;
    private LocalDate postedTime;
    private LocalDate updatedTime;
}
