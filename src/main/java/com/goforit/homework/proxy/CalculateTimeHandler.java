package com.goforit.homework.proxy;

import com.goforit.homework.annotate.CaculateTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by junqingfjq on 16/5/5.
 */
public class CalculateTimeHandler implements InvocationHandler{

    private Object target;

    public CalculateTimeHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Class<?> [] argClasses=null;
        if(args!=null){
            argClasses=new Class<?>[args.length];
            int i=0;
            for(Object arg:args){
                argClasses[i]=arg.getClass();
                i++;
            }
        }

        Method me=target.getClass().getDeclaredMethod(method.getName(),argClasses);

        boolean isAnnotation=false;
        System.err.println("method is "+me.getName());
        if(me.isAnnotationPresent(CaculateTime.class) || method.isAnnotationPresent(CaculateTime.class)){
            isAnnotation=true;
        }

        if(isAnnotation){
            System.err.println("begin to calculate time:"+ new Date());
        }

        Object result=method.invoke(target,args);

        if(isAnnotation){
            System.err.println("end to calculate time:"+new Date());
        }
        return result;
    }
}

