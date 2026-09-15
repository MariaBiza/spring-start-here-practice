package main;

import main.model.Comment;
import main.proxies.EmailCommentNotificationProxy;
import main.repositories.DBCommentRepository;
import main.services.CommentService;

public class Main {

    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Maria");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
    }
}
