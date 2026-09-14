package main;

import config.ProjectConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class MainTest {

    @Test
    public void getParrotName_Success() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
