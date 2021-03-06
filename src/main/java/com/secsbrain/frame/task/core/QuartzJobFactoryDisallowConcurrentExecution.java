package com.secsbrain.frame.task.core;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @Description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * @author zhaoyi
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final TaskDefine scheduleJob = (TaskDefine) context.getMergedJobDataMap().get("scheduleJob");
        System.out.println(scheduleJob.getJobName());
        TaskUtils.invokMethod(scheduleJob); 
    }
}