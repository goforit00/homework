package com.goforit.homework.annotate;

import java.lang.annotation.*;

/**
 * Created by junqingfjq on 16/5/4.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color{BULE,RED,GREEN};

    Color fruitColor() default Color.RED;
}
