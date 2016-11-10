package faculty.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Mi on 02.11.2016.
 */
@Aspect
public class MyAspect {

    private static final Logger logger = Logger.getLogger(MyAspect.class);

    //  @Around("execution(public * faculty.service..*(..))")


      @Around("execution(public * faculty.service..*(..))")
  //@Around(value = "publicMethodsPointCut()")
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
      String methodName = proceedingJoinPoint.getSignature().getName();
      System.out.printf("before method %s\n", methodName);

      Object value = null;

      try {
          value =  proceedingJoinPoint.proceed();
      } catch (Throwable throwable) {
          throwable.printStackTrace();
      }

      System.out.printf("after method %s\n", methodName);

      return value;
    }

//    private Logger logger;
//
//    public void addAppender(){
//
//        logger = Logger.getRootLogger();
//        logger.setLevel(Level.INFO);
//        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
//        logger.addAppender(new ConsoleAppender(layout));
//
//    }
//
//    public void before(ProceedingJoinPoint proceedingJoinPoint){
//        logger.info("Before method " + proceedingJoinPoint.getSignature());
//    }
//
//    public void after(ProceedingJoinPoint proceedingJoinPoint){
//        logger.info("After method " + proceedingJoinPoint.getSignature());
//    }
//
//    public void afterReturning(ProceedingJoinPoint proceedingJoinPoint){
//        logger.info("After returning " + proceedingJoinPoint.getSignature());
//    }
//
//    public void afterThrowing(ProceedingJoinPoint proceedingJoinPoint){
//        logger.info("After throwing " + proceedingJoinPoint.getSignature());
//    }
//
//    public Object around(ProceedingJoinPoint joinPoint){
//        Object object = null;
//        try {
//            before(joinPoint);
//            object = joinPoint.proceed(); //atart our joinpoint
//            after(joinPoint);
//            afterReturning(joinPoint);
//        } catch (Throwable throwable) {
//            afterThrowing(joinPoint);
//        }
//
//        return object;
//    }
}

