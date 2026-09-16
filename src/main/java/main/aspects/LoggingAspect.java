package main.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class LoggingAspect {

    @Around("execution(* main.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Method will execute");
        joinPoint.proceed();
        log.info("Method executed");
    }
}
