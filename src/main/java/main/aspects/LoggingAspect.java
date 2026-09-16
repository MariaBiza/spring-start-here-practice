package main.aspects;

import lombok.extern.slf4j.Slf4j;
import main.model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
@Slf4j
public class LoggingAspect {

    @Around("execution(* main.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        log.info("Method {} with parameters {} will execute", methodName, Arrays.asList(arguments));

        Comment comment = new Comment();
        comment.setText("Some other text!");
        Object[] newArguments = {comment};

        Object returnedByMethod = joinPoint.proceed(newArguments);

        log.info("Method executed and returned {}", returnedByMethod);

        return "FAILED";
    }
}
