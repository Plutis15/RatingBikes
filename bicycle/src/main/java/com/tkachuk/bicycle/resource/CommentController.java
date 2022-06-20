package com.tkachuk.bicycle.resource;

import com.tkachuk.bicycle.entity.Bicycle;
import com.tkachuk.bicycle.entity.Comment;
import com.tkachuk.bicycle.entity.DTO.CommentDTO;
import com.tkachuk.bicycle.service.BicycleService;
import com.tkachuk.bicycle.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final BicycleService bicycleService;

    public CommentController(CommentService commentService, BicycleService bicycleService) {
        this.commentService = commentService;
        this.bicycleService = bicycleService;
    }

    @GetMapping("/allComments")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<CommentDTO>> findAllCommentsDtos() {
        List<CommentDTO> commentDTOS = commentService.findAllCommentsDtos();
        return new ResponseEntity<>(commentDTOS, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment newComment = commentService.addComment(comment);
        Bicycle newBicycle = bicycleService.findBicycleById(comment.getBicycleId());

        Integer newCommentCnt = newBicycle.getCommentCount();
        newBicycle.setCommentCount(++newCommentCnt);
        Integer newMarkCnt = newBicycle.getMarkCount();
        newBicycle.setMarkCount(newMarkCnt + comment.getMark());
        System.out.println("Dividing marks ->" + ((double) newBicycle.getMarkCount() / newBicycle.getCommentCount()));
        newBicycle.setMark(((double) newBicycle.getMarkCount() / newBicycle.getCommentCount()));
        System.out.println("Getting mark ->" + newBicycle.getMark());
        bicycleService.updateBicycle(newBicycle);

        return new ResponseEntity<>(newComment, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
