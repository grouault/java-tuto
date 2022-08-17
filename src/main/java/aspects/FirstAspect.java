package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FirstAspect {

    @Pointcut("execution(* test.Application.main(..))")
    public void pc1() {}

    /*
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("************************************");
        System.out.println("Before Main Aspect with class syntax");
        System.out.println("************************************");
    }

    @After("pc1()")
    public void afterMain(){
        System.out.println("************************************");
        System.out.println("After Main Aspect with class syntax");
        System.out.println("************************************");
    }
    */

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("************************************");
        System.out.println("Round Before Main Aspect with class syntax");
        System.out.println("************************************");

        Object value = pj.proceed();

        System.out.println("************************************");
        System.out.println("Round After Main Aspect with class syntax");
        System.out.println("************************************");

        return value;

    }


}
