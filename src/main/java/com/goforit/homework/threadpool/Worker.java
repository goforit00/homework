package com.goforit.homework.threadpool;

import java.util.List;

/**
 * Created by junqingfjq on 16/5/18.
 */
public class Worker implements Runnable {

    private boolean running=true;

    private List<JobExecutor> jobs;

    public Worker(List<JobExecutor> jobs){
        this.jobs=jobs;
    }

    @Override
    public void run() {

        while (running){
            JobExecutor job=null;

//            System.err.println("begin thread "+Thread.currentThread().getName());
            synchronized (jobs){
                while (jobs.isEmpty()){
                    try {

                        jobs.wait();
                    }catch (Exception e){

                    }
                }
                job=jobs.remove(0);
            }

            if(job!=null){
                try{
                    job.run();
                }catch (Exception e){

                }
            }

//            running=false;
        }

    }

    public void shutdown(){
        running=false;
    }
}
