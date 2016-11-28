package faculty.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Mi on 02.11.2016.
 */

    /**
     * Created by Mi on 27.10.16.
     */
    @Aspect
    public class LoggingAspect {

        @Around("execution(public * faculty.service..*(..))")
        public Object  writeToLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            System.out.println("In " + proceedingJoinPoint.getSignature());

            Object object = null;
            try {
                object = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw throwable;
            }

            System.out.println("After " + proceedingJoinPoint.getSignature());

            return object;

        }
    }