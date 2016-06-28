package com.goforit.homework.waitnotify;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/5/18.
 */
public class WaitNotifyTest {

    static Object obj=new Object();

    static boolean flag=true;

    public static void main(String [] argvs) throws Exception{



        Thread waitThread1=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){

                    while (flag){

                        try{
                            System.err.println(Thread.currentThread().getName()+": flag is true. to wait"+" "+new Date());
                            obj.wait();
                            System.err.println(Thread.currentThread().getName()+": flag is true. to wait end"+" "+new Date());

                        }catch (Exception e){

                        }

                    }

                }

            }
        },"waitThread1");

        Thread waitThread2=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){

                    while (flag){

                        try{
                            System.err.println(Thread.currentThread().getName()+": flag is true. to wait"+" "+new Date());
                            obj.wait();
                            System.err.println(Thread.currentThread().getName()+": flag is true. to wait end"+" "+new Date());

                        }catch (Exception e){

                        }

                    }

                }

            }
        },"waitThread2");

        waitThread1.start();
        waitThread2.start();

        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){

                    System.err.println(Thread.currentThread().getName()+": to notify all, flag is "+flag+" "+new Date());
                    obj.notifyAll();

                    System.err.println(Thread.currentThread().getName()+": to notify all end1, flag is "+flag+" "+new Date());

                    flag=false;

                    System.err.println(Thread.currentThread().getName()+": to notify all end2, flag is "+flag+" "+new Date());

                    try{
                        TimeUnit.SECONDS.sleep(3);
                    }catch (Exception e){

                    }
                }

            }
        },"notifyThread");

        notifyThread.start();


    }
}
