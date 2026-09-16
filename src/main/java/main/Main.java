package main;

import lombok.extern.slf4j.Slf4j;
import main.config.ProjectConfiguration;
import main.model.Comment;
import main.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var service = context.getBean(CommentService.class);
        var comment = new Comment();
        comment.setAuthor("Maria");
        comment.setText("Demo comment");

        String value = service.publishComment(comment);

        log.info(value);
    }
}
