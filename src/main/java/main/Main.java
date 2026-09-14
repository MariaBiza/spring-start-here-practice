package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot1 = context.getBean(Parrot.class);
        System.out.println(parrot1.getName());

        Parrot parrot2 = context.getBean("miki", Parrot.class);
        System.out.println(parrot2.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
