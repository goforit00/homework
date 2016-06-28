package com.goforit.homework.threadlocal;

/**
 * Created by junqingfjq on 16/5/18.
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Long> TIME_LOCAL=new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };


    public static final void begin(){
        TIME_LOCAL.set(100L);
        System.err.println(TIME_LOCAL.get());
    }

    public static final void end(){
        TIME_LOCAL.set(TIME_LOCAL.get() + 1);
        System.err.println(TIME_LOCAL.get());

    }


    public static void main(String [] argv){

        System.err.println(TIME_LOCAL.get());
        begin();
        end();

        System.err.println(TIME_LOCAL.get());

    }
}
