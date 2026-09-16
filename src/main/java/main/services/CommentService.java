package main.services;

import lombok.extern.slf4j.Slf4j;
import main.model.Comment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService {

    public void publishComment(Comment comment) {
        log.info("Publish comment: {}", comment.getText());
    }
}
