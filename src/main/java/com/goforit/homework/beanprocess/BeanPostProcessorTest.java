package com.goforit.homework.beanprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by junqingfjq on 16/5/6.
 */


public class BeanPostProcessorTest implements BeanPostProcessor {

//    private TimeoutCallbackFactory factory=TimeoutCallbackFactory.INSTANCE;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("post process after initialization");
        return bean;
    }
}
