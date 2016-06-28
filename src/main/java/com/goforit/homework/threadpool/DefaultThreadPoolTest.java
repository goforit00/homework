package com.goforit.homework.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/5/18.
 */
public class DefaultThreadPoolTest {

    public static void main(String [] argvs){

        DefaultThreadPool threadPool=new DefaultThreadPool();

        JobExecutor job=new JobExecutor() {
            @Override
            public void run() {
                System.err.println("hello "+Thread.currentThread().getName());
            }
        };

        for(int i=1;i<100;i++){
            threadPool.execute(job);
        }


        try {
            TimeUnit.SECONDS.sleep(2);

        }catch (Exception e){

        }
    }
}
