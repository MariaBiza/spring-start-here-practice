package main.services;

import lombok.extern.slf4j.Slf4j;
import main.aspects.ToLog;
import main.model.Comment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService {

    public void publishComment(Comment comment) {
        log.info("Publishing comment: {}", comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        log.info("Deleting comment: {}", comment.getText());
    }

    public void editComment(Comment comment) {
        log.info("Editing comment: {}", comment.getText());
    }
}
