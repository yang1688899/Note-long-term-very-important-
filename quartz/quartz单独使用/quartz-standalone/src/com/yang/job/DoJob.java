package com.yang.job;

import java.util.concurrent.TimeUnit;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class DoJob {
	
	public static void main(String[] args) {
		
		
        try {
        	// 获取Scheduler实例
        	Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			// 具体任务
			JobDetail jobDetail = JobBuilder.newJob(Hello.class).build();
			
			// 触发时间点
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                    .startNow().withSchedule(simpleScheduleBuilder).build();
            
            // 交由Scheduler安排触发
            scheduler.scheduleJob(jobDetail, trigger);
            
            /* 为观察程序运行，此设置主程序睡眠3分钟才继续往下运行（因下一个步骤是“关闭Scheduler”） */
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // 关闭Scheduler
            scheduler.shutdown();
            
		} catch (SchedulerException e) {
			
			e.printStackTrace();
		}
	}

}
