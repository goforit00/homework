package com.goforit.homework.annotate;

import java.lang.annotation.*;

/**
 * Created by junqingfjq on 16/5/4.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  CaculateTime {

    public enum Type{SECONDS,MINUTES};

    Type type() default Type.SECONDS;
}
