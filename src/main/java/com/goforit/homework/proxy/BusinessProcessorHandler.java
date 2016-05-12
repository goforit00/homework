package com.goforit.homework.proxy;

import com.goforit.homework.annotate.CaculateTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by junqingfjq on 16/5/4.
 */
public class BusinessProcessorHandler implements InvocationHandler {

    private Object target=null;

    BusinessProcessorHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.err.println("before process business");

        Object result=method.invoke(target,args);

        System.err.println("after process business");

        return result;
    }

    public static void main(String[] args){
        BusinessProcessorImpl bpImpl=new BusinessProcessorImpl();
        Object object=proxyAnno(bpImpl);
        System.err.println(object.getClass().getName());
        ((BusinessProcessor)object).processBusiness();
        ((BusinessProcessor)object).processBusiness2();


//        BusinessProcessorHandler handler=new BusinessProcessorHandler(bpImpl);
//
//        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(bpImpl.getClass()
//            .getClassLoader(), bpImpl.getClass().getInterfaces(), handler);
//
//        bp.processBusiness();
//        bp.processBusiness2();

    }

    public static  Object proxyAnno(Object obj){
        Method [] methods=obj.getClass().getDeclaredMethods();

        boolean hasCalculateAnno=false;

        Class<?> [] interfaces=obj.getClass().getInterfaces();

        for(Class<?> inter:interfaces){
            Method [] interMethods=inter.getDeclaredMethods();
            for(Method m:interMethods){
                if(m.isAnnotationPresent(CaculateTime.class)){
                    hasCalculateAnno=true;
                    break;
                }
            }
        }

        for(Method method:methods){
            if(method.isAnnotationPresent(CaculateTime.class)){
                hasCalculateAnno=true;
                break;
            }
        }
        
        if(hasCalculateAnno){
            CalculateTimeHandler handler=new CalculateTimeHandler(obj);
            obj=Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
        }

        return obj;

    }



}
