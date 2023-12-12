package com.example.demo.Repository;

import com.example.demo.Entity.InnerComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerCommentsRepository extends JpaRepository<InnerComments , Integer> {
}
