package com.goforit.homework.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by junqingfjq on 16/5/12.
 */
public class AtomicTest {

    public static void main(String argv[]){
        AtomicInteger count=new AtomicInteger(0);

        int newCount=count.addAndGet(10);
        System.err.println(newCount);
    }
}
