package com.goforit.homework.threadpool;

/**
 * Created by junqingfjq on 16/5/18.
 */
public interface ThreadPool {

    void execute(JobExecutor job);

    void shutdown();

    void addWorkers(int num);

    void removeWorkers(int num);

    int getJobNum();
}
