package aspects;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;

@Aspect
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    public LoggingAspect()throws IOException{
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    long t1, t2;

    @Pointcut("execution(* metier.*.*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void beforeLog(JoinPoint jp) {
        t1 = System.currentTimeMillis();
        logger.info("-----------------");
        logger.info("Avant l'exécution de la méthode : " + jp.getSignature());
    }

    @After("pc1()")
    public void afterLog(JoinPoint jp){
        logger.info("Après l'exécution de la méthode " + jp.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("Durée d'exécution de la méthode : " + (t2 - t1) + " ms");
        logger.info("-----------------");
    }


}
