package az.edu.turing.bookingapp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* az.edu.turing.bookingapp.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Start: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* az.edu.turing.bookingapp.service..*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("End: {} with result: {}", joinPoint.getSignature(), result);
    }
}


