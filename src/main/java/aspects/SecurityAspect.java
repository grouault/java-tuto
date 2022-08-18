package aspects;

import java.util.Scanner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* test.Application.start(..))")
    public void pc1() {}

    @Around("pc1()")
    public Object autourStart(ProceedingJoinPoint pj) throws Throwable {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        String login = scanner.next();
        System.out.println("Password");
        String pwd = scanner.next();

        Object value = null;
        if (login != null && pwd != null && "test".equals(login) && "test".equals(pwd)) {
            value = pj.proceed();
        } else {
           throw new RuntimeException("Access Denied");
        }
        return value;

    }

}
