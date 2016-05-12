package com.goforit.homework.quartz;

import org.quartz.*;
import org.quartz.JobBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by junqingfjq on 16/5/6.
 */
public class QuartzTest  implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("hello quartz");
    }

    public static void main(String argv[]){
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler=null;

        try{
            scheduler=schedulerFactory.getScheduler();

            JobDetail jobDetail=JobBuilder.newJob(QuartzTest.class).withIdentity("JobName","JobGroupName").build();

            Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("CronTrigger1", "CronTriggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?")).startNow().build();

                scheduler.scheduleJob(jobDetail,trigger);

            scheduler.start();

//            Thread.sleep(10000);
            System.err.println("aa");
//            scheduler.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
