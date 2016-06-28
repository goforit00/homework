package com.goforit.homework.threadpoolmonitor;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by junqingfjq on 16/6/2.
 */
public class ThreadPoolMonitorTest {

    public static void main(String [] argvs){
        ThreadPoolExecutor threadPool=new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS,null);
        threadPool.getActiveCount();
//        threadPool.setMaximumPoolSize();
    }
}
