package com.goforit.homework.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by junqingfjq on 16/5/18.
 */
public class DefaultThreadPool implements ThreadPool{

    private static final int MAX_WORKER_NUMBERS=10;

    private static final int DEFAULT_WORKER_NUMBERS=5;

    private static final int MIN_WORKER_NUMBERS=1;

    private final LinkedList<JobExecutor> jobs=new LinkedList<JobExecutor>();

    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());

    private AtomicInteger jobNum=new AtomicInteger(0);

    private AtomicInteger workerNum=new AtomicInteger(0);


    public DefaultThreadPool(){
        initDefaultThreadPool();
    }

    private void initDefaultThreadPool(){
        for(int i=0;i<DEFAULT_WORKER_NUMBERS;i++){
            Worker w=new Worker(jobs);
            Thread thread=new Thread(w,"Thread-"+workerNum.get());
            workerNum.incrementAndGet();
            thread.start();
        }
    }

    @Override
    public void execute(JobExecutor job) {
        if(job!=null){
            synchronized (jobs){
                jobs.add(job);
                jobNum.incrementAndGet();

                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        synchronized (workers){
            for(Worker w:workers){
                w.shutdown();
            }
        }
    }

    @Override
    public void addWorkers(int num) {

        synchronized (workers){
            if(workerNum.get()+num<=MAX_WORKER_NUMBERS){
                for(int i=0;i<num;i++){
                    Worker w=new Worker(jobs);
                    Thread thread=new Thread(w,"Thread-"+workerNum.get());
                    workerNum.incrementAndGet();
                    thread.start();
                }
            }
        }
    }

    @Override
    public void removeWorkers(int num) {

        synchronized (workers){
            if(workerNum.get()-num<MIN_WORKER_NUMBERS){
                throw new RuntimeException("cant remove all workers");
            }

            int count=0;
            while (count<num){
                Worker w=workers.get(count);
                w.shutdown();
                workerNum.decrementAndGet();
                count++;
            }
        }

    }

    @Override
    public int getJobNum() {
        return jobNum.get();
    }
}
