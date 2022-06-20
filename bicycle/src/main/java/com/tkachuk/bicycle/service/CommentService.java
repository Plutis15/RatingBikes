package com.tkachuk.bicycle.service;

import com.tkachuk.bicycle.entity.Comment;
import com.tkachuk.bicycle.entity.DTO.CommentDTO;
import com.tkachuk.bicycle.entity.UserEntity;
import com.tkachuk.bicycle.exception.CommentNotFoundException;
import com.tkachuk.bicycle.repo.BicycleRepository;
import com.tkachuk.bicycle.repo.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CommentService {
    BicycleRepository bicycleRepository;
    CommentRepository commentRepository;
    UserService userRepository;

    public Comment findCommentById(Long id) {
        return commentRepository.findCommentById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment was not found with id: " + id));
    }

    public List<CommentDTO> findAllCommentsDtos() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Long deleteComment(Long id) {
        return commentRepository.deleteCommentById(id).orElseThrow(() -> new CommentNotFoundException("Cannot delete comment with id: "  + id
                + ", because there is no such id"));
    }

    private CommentDTO convertToDto(Comment comment) {
        UserEntity userEntity = userRepository.findUserEntityById(comment.getUserId());

        return new CommentDTO(userEntity.getImageURL(), comment.getText(), userEntity.getFirstName(), userEntity.getLastName(), comment.getMark());
    }
}
