package main;

import config.ProjectConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootTest
public class MainTest {

    @Test
    public void getParrotName_Success() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();
        x.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot p = context.getBean(Parrot.class);

        Assert.assertEquals("Kiki", p.getName());
    }
}
