package aopexam;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Before("execution(* aopexam.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before::::::::::::::::::"+joinPoint.getSignature().getName());
    }

    @After("execution(* aopexam.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("After::::::::::::::::::"+joinPoint.getSignature().getName());
    }
}
