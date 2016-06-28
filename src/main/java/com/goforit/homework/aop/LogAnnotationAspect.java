package com.goforit.homework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by junqingfjq on 16/5/20.
 */

@Aspect
public class LogAnnotationAspect {

    @Pointcut("execution(* com.goforit.homework.aop.*.*(..))")
    private void allMethod(){}

    @Before("execution(* com.goforit.homework.aop.*.*(..))")
    public void before(JoinPoint call){
        String className=call.getTarget().getClass().getName();
        String methodName=call.getSignature().getName();
        System.err.println("before annotation: class "+className+",method "+methodName);
    }

    @AfterReturning("allMethod()")
    public void afterReturn(){
        System.err.println("方法正常结束");
    }

    @After("allMethod()")
    public void after(){
        System.err.println("方法结束之后必定执行");
    }


}
