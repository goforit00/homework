package com.goforit.homework.fibonacci;

import java.util.Date;

/**
 * Created by junqingfjq on 16/5/30.
 */
public class FibonacciTest {

    public static void main(String argv[]){
        long fi=50;
        long total=fibonacci(fi);
        System.err.println(new Date());
        System.err.println(fi+" fibonacci ="+total);
        System.err.println(new Date());
        total=fibonacci2(fi);
        System.err.println(fi+" fibonacci ="+total);
        System.err.println(new Date());
    }



    public static long fibonacci(long n){

        if(n<=2){
            return 1;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static long fibonacci2(long n){

        long fb1=1;
        long fb2=1;

        long fbTotal=0;

        while (n>2){
            fbTotal=fb1+fb2;
            fb1=fb2;
            fb2=fbTotal;
            n--;
        }

        return fbTotal;

    }
}
