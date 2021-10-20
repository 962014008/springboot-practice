package cn.stackbox.demo.aspect;

import cn.stackbox.demo.annotation.TestAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 定义切面
 */

@Aspect
@Component
public class BrokerAspect {

    @Pointcut("@annotation(cn.stackbox.demo.annotation.TestAnnotation)")
    public void BrokerAspect() {}

    @Around("BrokerAspect()")
    public Object doAroundFunction(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        //得到目标方法
        Method method = signature.getMethod();
        //得到方法之上的注解
        TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
        //注解业务判断
        if ("yes".equals(testAnnotation.name())) {
            System.out.println("name的值为yes对应的业务");
        } else {
            System.out.println("name的值为no对应的业务");
        }
        return point.proceed();
    }

}
