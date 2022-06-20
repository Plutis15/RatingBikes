package com.tkachuk.bicycle.repo;

import com.tkachuk.bicycle.entity.Bicycle;
import com.tkachuk.bicycle.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentById(Long id);

    Optional<Long> deleteCommentById(Long id);

}
